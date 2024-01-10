#include <stdio.h>
#define MAX 100
int main(int argc, char *argv[]) {
	
	int x,num;
	num=0;
		
		for (x=1;x<=MAX;x+=2) 
		{  
			num=num+1;
			printf ("%d ",x);
			
		}
		printf ("\n");
		printf ("El numero total de impares es %d",num);
	
	
	
	return 0;
}

