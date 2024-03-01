#include <stdio.h>



void vis(int z[],int tam){
	int i;
	for (i = 0; i < tam; i++) 	
		printf("%p-->%d\n",(z+i),*(z+i));
	
}


void visConDir1(int xx[], int conDir){
	int i;
	for (i = 0; i < 5; i++) 	
		if(conDir)
			printf(" %p-->%d ",(xx+i),*(xx+i));
		else
			printf(" %d:%d ",(i+1),*(xx+i));	
}


void visConDir2(int xx[], char *fto){
	int i;
	for (i = 0; i < 5; i++) 			
		printf(fto,(xx+i),*(xx+i));
		
}






int *concatena(int *x,int *y, int tamx, int tamy)
{	
	int i,j=0;
	int *res=malloc((tamx+tamy)*sizeof(int));
	for (i = 0; i < tamx; i++,j++) 	
		*(res+j)=*(x+i);
	
	for (i = 0; i < tamy; i++,j++) 	
		*(res+j)=*(y+i);
	
	return res;
}

int main(int argc, char *argv[]) 
{
	
	int x[]={1,2,4,4,5,6,6,7,88};
	int y[]={1,77,17};			
	
	
	int tamx= *(&x + 1) - x;
	int tamy= *(&y + 1) - y;
	
	int *z=concatena(x,y,tamx,tamy);
	int i;
	
	vis(z,tamx+tamy);	
	
	
	return 0;
}

