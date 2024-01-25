#include <stdio.h>
#define Alto 15
int main(int argc, char *argv[]) {
	
	
	int i,j,cont=Alto;
	
	for(i=0;i<Alto;i++)
	{
		
		for(j=Alto;j>i;j--)
		{
			printf("   ");
		}
		
		for(j=i;j>=0;j--)
		{
			printf("%3d",j+1);
		}
			
		for(j=1;j<=i;j++)
		{
			printf("%3d",j+1);
		}
		putchar('\n');
	}
	
	return 0;
}

