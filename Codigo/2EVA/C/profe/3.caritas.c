#include <stdio.h>

int main(int argc, char *argv[]) {

	int i,j,z;
	char op;


	char cad1[]="******";
	char cad2[]="**__**";
	char cad3[]="******";


	char smilie[][2][6]=
		{
			{
				" *  * ",
				" \\__/ "
			},


			{	" *  * ",
				" ---- "
			}
		};

	do{
        puts("");
        printf("\tTeclea un número del 1 al 3:");op=getch();

		printf("%d",op);
		
        puts("");
        puts("");
		z=op-'1';
		if(op=='1' || op=='2')
        {
			/*Dibujo un smilei*/
			for(j=0;j<2;j++)
			{
				/*Dibujo una línea*/
				for(i=0;i<6;i++){
					printf("%c",smilie[z][j][i]);
				}
				printf("\n");
			}
		}else{
            puts(cad1);
            puts(cad2);
            puts(cad3);
		}
	}while(op=='1' || op=='2');



	return 0;
}

