
/***************************************************************************
***************************************************************************
    Creo este fich xa usar gr�ficos
        en todos los compiladores q no sean
                    ni de Borland ni el LCC
***************************************************************************
****************************************************************************/

#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

#include <stdarg.h>
#include <windef.h>
#include <winbase.h>
#include <wincon.h>
#include <windows.h>


#define _NOCURSOR      0
#define _SOLIDCURSOR   1
#define _NORMALCURSOR  2
#define C40 1


#define cprintf printf
#define cscanf scanf


#define gettext Gettext


struct text_info {
    unsigned char winleft;
    unsigned char wintop;
    unsigned char winright;
    unsigned char winbottom;
    unsigned char attribute;
    unsigned char normattr;
    unsigned char currmode;
    unsigned char screenheight;
    unsigned char screenwidth;
    unsigned char curx;
    unsigned char cury;
};

enum COLORS { BLACK, BLUE, GREEN, CYAN, RED, MAGENTA, BROWN, LIGHTGRAY,
              DARKGRAY, LIGHTBLUE, LIGHTGREEN, LIGHTCYAN, LIGHTRED,
              LIGHTMAGENTA, YELLOW, WHITE } ;



/***************************************************************************
***************************************************************************
                            FUNCIONES
***************************************************************************
****************************************************************************/


void _setcursortype(int type);
char *cgets(char *str);
void clreol();
void clrscr();
void delline();


int cputs(const char *str) ;

int Gettext(int left, int top, int right, int bottom, void *destin) ;



void gettextinfo(struct text_info *_r);

int MYgetch(void) ;
int MYgetche(void) ;

void gotoxy(int x, int y);

void highvideo();
void insline();

void lowvideo();
int movetext(int left, int top, int right, int bottom, int destleft, int desttop);
void normvideo();

int puttext(int left, int top, int right, int bottom, void *source);

void textattr(int _attr);
void textbackground(int _color);
void textcolor(int _color);

int wherex();
int wherey();

void MYclrwin(int left, int top, int right, int bottom);


void MYwindow(int left, int top, int right, int bottom);
/* void window(int left, int top, int right, int bottom); */


void borrarPantalla();
void borrarLinea();



/***************************************************************************
***************************************************************************
                            IMPLEMENTACI�N
***************************************************************************
****************************************************************************/

void _setcursortype(int type)
{
  CONSOLE_CURSOR_INFO Info;
  Info.bVisible = TRUE;
  if (type == _NOCURSOR) Info.bVisible = FALSE;
  else if (type == _SOLIDCURSOR) Info.dwSize = 90 ;
  else if (type == _NORMALCURSOR) Info.dwSize = 1;
  SetConsoleCursorInfo (GetStdHandle (STD_OUTPUT_HANDLE), &Info);
}

char *cgets(char *str)
{
    int i=2 ;
    while((str[i]=MYgetch()) != '\r')
    {
        switch(str[i])
        {
            case '\b' : if(i<=2) break ; // pas de caract�re � effacer
                        printf("\b \b") ;
                        i -- ;
                        break ;
            case 0    :
            case -32  : MYgetch() ; // lire le 2�me caract�re des codes �tendus
            case 9    :           // ne pas tenir compte de la touche [TAB]
            case 27   : break ;   // ne pas tenir compte de la touche [ESC]
            default   : if(i<=str[0])
                            putch(str[i++]) ;
       }
    }
    str[i] = 0 ;
    str[1] = i - 2 ;
    return str + 2 ;
}

void clreol()
{
  COORD coord = {wherex() - 1 , wherey() - 1};
  DWORD dwWritten;
  HANDLE hScreen=GetStdHandle(STD_OUTPUT_HANDLE) ;
  CONSOLE_SCREEN_BUFFER_INFO Info;

    if(GetConsoleScreenBufferInfo(hScreen, &Info))
    {
        FillConsoleOutputCharacter (hScreen, ' ', Info.dwSize.X-coord.X, coord,
                        &dwWritten);
        FillConsoleOutputAttribute (hScreen, Info.wAttributes,
                        Info.dwSize.X-coord.X, coord, &dwWritten);
        gotoxy (coord.X, coord.Y) ;
    }
}

void clrscr(void) // efface l'�cran
{
  // Premi�re solution :         OK !
  COORD coord = { 0, 0 } ; //  coord.X = 0;  coord.Y = 0;
  DWORD dwWritten, dwSize ;
  HANDLE hScreen=GetStdHandle(STD_OUTPUT_HANDLE) ;
  CONSOLE_SCREEN_BUFFER_INFO Info;

  if(GetConsoleScreenBufferInfo(hScreen, &Info))
  {
      dwSize = Info.dwSize.X * Info.dwSize.Y ;
      FillConsoleOutputCharacter (hScreen, ' ', dwSize, coord, &dwWritten);
      FillConsoleOutputAttribute (hScreen, Info.wAttributes, dwSize, coord,
                  &dwWritten);
      gotoxy (1, 1);
  }
  /* Seconde solution : moins efficace - n�cessite plus de temps
                      - ne prend pas en compte les couleurs */
  /*
  system("cls") ;
  */
}

int cputs(const char *str) {
  return ((printf ("%s\n", str)==EOF)?EOF:(int)*(str+strlen(str)-1)) ;
}

void delline()
{
    int y=wherey() ;
    HANDLE hScreen = GetStdHandle(STD_OUTPUT_HANDLE) ;
    CONSOLE_SCREEN_BUFFER_INFO Info ;
    GetConsoleScreenBufferInfo(hScreen, &Info) ;
    {
        COORD dwBufferSize={Info.dwSize.X, Info.dwSize.Y - y} ;
        COORD dwBufferCoord={0, 0} ;
        CHAR_INFO Buffer[dwBufferSize.Y][dwBufferSize.X] ;
        SMALL_RECT ReadRegion[2] ;
        ReadRegion[0].Left = 0 ;
        ReadRegion[0].Right = Info.dwSize.X-1 ;
        ReadRegion[0].Top = y ;
        ReadRegion[0].Bottom = Info.dwSize.Y-1 ;

        ReadConsoleOutput(hScreen, (CHAR_INFO*)Buffer, dwBufferSize,
                        dwBufferCoord, ReadRegion) ;
        ReadRegion[0].Top = y-1 ;
        ReadRegion[0].Bottom = Info.dwSize.Y-2 ;
        WriteConsoleOutput(hScreen, (CHAR_INFO*)Buffer, dwBufferSize,
                        dwBufferCoord, ReadRegion) ;
    }
}

int MYgetch(void)
{
    char Temp[3] ;
    int Ret=getch() ;
    if (Ret==0x0D) gets(Temp) ;
    /* Si la touche choisie par l'utilisateur est <CR> alors
       � FlushConsoleInputBuffer � ne fonctionne pas d'o� l'astuce avec gets. */
    else FlushConsoleInputBuffer(GetStdHandle(STD_INPUT_HANDLE)) ;
    /* � fflush(stdin) ;  � ne fonctionne pas ! Sans effet apparent ! */
    return Ret ;
}

int MYgetche(void)
{
     char Temp[3] ;
     int Ret=getche() ;
     if (Ret==0x0D) gets(Temp) ;
     else FlushConsoleInputBuffer(GetStdHandle(STD_INPUT_HANDLE)) ;
     return Ret ;
}

//#define getch MYgetch  // permet de remplacer getch (conio, mingw) par MYgetch
//#define getche MYgetche

int Gettext(int left, int top, int right, int bottom, void *destin)
{
    int ValueReturn, x, y ;
    HANDLE hScreen = GetStdHandle(STD_OUTPUT_HANDLE) ;
    COORD dwBufferSize={right-left+1, bottom-top+1} ;
    COORD dwBufferCoord={0,0} ;
    CHAR_INFO Buffer[dwBufferSize.Y][dwBufferSize.X] ;
    SMALL_RECT ReadRegion[2] ;
    ReadRegion[0].Left = left-1 ;
    ReadRegion[0].Right = right-1 ;
    ReadRegion[0].Top = top-1 ;
    ReadRegion[0].Bottom = bottom-1 ;

    ValueReturn=ReadConsoleOutput(hScreen, (CHAR_INFO*) Buffer, dwBufferSize,
            dwBufferCoord, ReadRegion) ;

    for (x=0 ; x<dwBufferSize.X ; x++)
    {
       for (y=0 ; y<dwBufferSize.Y ; y++)
       {
          *((char*)destin+(2*(dwBufferSize.X*y+x)))=Buffer[y][x].Char.AsciiChar ;
          *((char*)destin+(2*(dwBufferSize.X*y+x)+1))=Buffer[y][x].Attributes ;
       }
    }
    return ValueReturn ;
}

void gettextInfo(struct text_info *_r)
{
  CONSOLE_SCREEN_BUFFER_INFO Info;
  GetConsoleScreenBufferInfo (GetStdHandle (STD_OUTPUT_HANDLE), &Info);
  _r->winleft = Info.srWindow.Left ;
  _r->winright = Info.srWindow.Right ;
  _r->wintop = Info.srWindow.Top ;
  _r->winbottom = Info.srWindow.Bottom ;
  _r->attribute = Info.wAttributes ;
  _r->normattr = LIGHTGRAY | (BLACK<<4) ;
  _r->currmode = C40 ;
  _r->screenheight = Info.dwSize.Y ;
  _r->screenwidth = Info.dwSize.X ;
  _r->curx = wherex () ;
  _r->cury = wherey () ;
}

/*
void gotoxy( int x, int y )
{
    printf( "\033[%d;%df", y, x );//Se pone al rev�s xq xa la consola es fila,columna

} // Fin de la funcion gotoxy
*/

void gotoxy(int x, int y) {
  COORD c ;
  c.X = x - 1;
  c.Y = y - 1;
  SetConsoleCursorPosition (GetStdHandle(STD_OUTPUT_HANDLE), c);
}

void highvideo() {
  CONSOLE_SCREEN_BUFFER_INFO Info ;
  GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &Info) ;
  textattr(Info.wAttributes | 0x08);
}

void insline()
{
    int y=wherey() ;
    HANDLE hScreen = GetStdHandle(STD_OUTPUT_HANDLE) ;
    CONSOLE_SCREEN_BUFFER_INFO Info ;
    GetConsoleScreenBufferInfo(hScreen, &Info) ;
    {
        COORD dwBufferSize={Info.dwSize.X, Info.dwSize.Y - y} ;
        COORD dwBufferCoord={0,0} ;
        COORD coord={0, y-1} ; // pour FillConsoleOutputCharacter
        CHAR_INFO Buffer[dwBufferSize.Y][dwBufferSize.X] ;
        DWORD dwWritten;
        SMALL_RECT ReadRegion[2] ;
        ReadRegion[0].Left = 0 ;
        ReadRegion[0].Right = Info.dwSize.X-1 ;
        ReadRegion[0].Top = y-1 ;
        ReadRegion[0].Bottom = Info.dwSize.Y-2 ;

        ReadConsoleOutput(hScreen, (CHAR_INFO*)Buffer, dwBufferSize, dwBufferCoord, ReadRegion) ;
        ReadRegion[0].Top = y ;
        ReadRegion[0].Bottom = Info.dwSize.Y-1 ;
        WriteConsoleOutput(hScreen, (CHAR_INFO*)Buffer, dwBufferSize, dwBufferCoord, ReadRegion) ;
        FillConsoleOutputCharacter (hScreen, ' ', Info.dwSize.X, coord, &dwWritten); // Effacer ligne
        FillConsoleOutputAttribute (hScreen, Info.wAttributes, Info.dwSize.X, coord, &dwWritten);
    }
}

void lowvideo() {
  CONSOLE_SCREEN_BUFFER_INFO Info ;
  GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &Info) ;
  textattr(Info.wAttributes & 0xF7);
}

int movetext(int left, int top, int right, int bottom, int destleft, int desttop)
{
//    int ValueReturn, x, y ;
    HANDLE hScreen = GetStdHandle(STD_OUTPUT_HANDLE) ;
    COORD dwBufferSize={right-left+1, bottom-top+1} ;
    COORD dwBufferCoord={0,0} ;
    CHAR_INFO Buffer[dwBufferSize.Y][dwBufferSize.X] ;
    SMALL_RECT ReadRegion[2] ;
    ReadRegion[0].Left = left-1 ;
    ReadRegion[0].Right = right-1 ;
    ReadRegion[0].Top = top-1 ;
    ReadRegion[0].Bottom = bottom-1 ;

    ReadConsoleOutput(hScreen, (CHAR_INFO*) Buffer, dwBufferSize, dwBufferCoord,
            ReadRegion) ;
    ReadRegion[0].Left = destleft-1 ;
    ReadRegion[0].Right = destleft-1+(dwBufferSize.X-1) ;
    ReadRegion[0].Top = desttop-1 ;
    ReadRegion[0].Bottom = desttop-1+(dwBufferSize.Y-1) ;
    return WriteConsoleOutput(hScreen, (CHAR_INFO*) Buffer, dwBufferSize,
            dwBufferCoord, ReadRegion) ;
}

void normvideo() {
    textattr(0x07) ; // LIGHTGRAY
}

int puttext(int left, int top, int right, int bottom, void *source)
{
    int x, y ;
    HANDLE hScreen = GetStdHandle(STD_OUTPUT_HANDLE) ;
    COORD dwBufferSize={right-left+1, bottom-top+1} ;
    COORD dwBufferCoord={0,0} ;
    CHAR_INFO Buffer[dwBufferSize.Y][dwBufferSize.X] ;
    SMALL_RECT ReadRegion[2] ;
    ReadRegion[0].Left = left-1 ;
    ReadRegion[0].Right = right-1 ;
    ReadRegion[0].Top = top-1 ;
    ReadRegion[0].Bottom = bottom-1 ;

    for (x=0 ; x<dwBufferSize.X ; x++)
    {
       for (y=0 ; y<dwBufferSize.Y ; y++)
       {
          Buffer[y][x].Char.AsciiChar = *((char*)source+(2*(dwBufferSize.X*y+x))) ;
          Buffer[y][x].Attributes = *((char*)source+(2*(dwBufferSize.X*y+x)+1)) ;
       }
    }

    return WriteConsoleOutput(hScreen, (CHAR_INFO*) Buffer, dwBufferSize,
            dwBufferCoord, ReadRegion) ;
}

void textattr(int _attr) {
  SetConsoleTextAttribute (GetStdHandle(STD_OUTPUT_HANDLE), _attr);
}

void textbackground(int _color) {
  CONSOLE_SCREEN_BUFFER_INFO Info ;
  GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &Info) ;
  textattr((Info.wAttributes & 0x0F) | (_color<<4));
}

void textcolor(int _color) {
  CONSOLE_SCREEN_BUFFER_INFO Info ;
  GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &Info) ;
  textattr((Info.wAttributes & 0xF0) | _color);
}

int wherex() {
  CONSOLE_SCREEN_BUFFER_INFO Info;
  GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &Info);
  return Info.dwCursorPosition.X + 1 ;
}

int wherey() {
  CONSOLE_SCREEN_BUFFER_INFO Info;
  GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &Info);
  return Info.dwCursorPosition.Y + 1 ;
}

void MYclrwin(int left, int top, int right, int bottom)
// efface une zone de l'�cran
{
  int i ;
  COORD dwCoord = {0, 0} ;
  COORD dwSize = {(right-left+1),(bottom-top+1)} ;
  HANDLE hScreen=GetStdHandle(STD_OUTPUT_HANDLE) ;
  CHAR_INFO Buffer[dwSize.X*dwSize.Y] ;
  SMALL_RECT Region[2] ;
  CONSOLE_SCREEN_BUFFER_INFO Info;

  if(GetConsoleScreenBufferInfo(hScreen, &Info))
  {
      for(i=0 ; i < dwSize.X*dwSize.Y ; i++)
      {
            Buffer[i].Char.AsciiChar=' ' ;
            Buffer[i].Attributes = Info.wAttributes ;
      }
      Region[0].Left = left-1 ;
      Region[0].Right = right-1 ;
      Region[0].Top = top-1 ;
      Region[0].Bottom = bottom-1 ;
      WriteConsoleOutput(hScreen, (CHAR_INFO*) Buffer, dwSize, dwCoord, Region) ;
      gotoxy (left, top);
  }

}

void MYwindow(int left, int top, int right, int bottom)
{
  SMALL_RECT R = {left, top, right, bottom } ;
  SetConsoleWindowInfo (GetStdHandle(STD_OUTPUT_HANDLE), TRUE, &R);
}




void borrarPantalla(){

	//Forma 1:
	system( "cls" );

	//Forma 2:
	printf("\033[2J");
}




void borrarLinea(){
	printf("\033[2K");
}

