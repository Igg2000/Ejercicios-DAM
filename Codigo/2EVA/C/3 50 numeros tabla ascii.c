#include <stdio.h>
#define MIN 97
#define MAX 25
int main(int argc, char *argv[])
{
	int i;
	int HayN=0;
	
	for (i=0;i<MAX+1;i++)
	{
		
		if (i+MIN==111)
		{
			printf ("%c ",164);
			int HayN=1;
		}
		
		if (HayN==1)
		{
			printf ("%c ",(i+MIN-1));
		}
		else
		{
			printf ("%c ",(i+MIN));
		}
				
		
		if ((i%10==0) && (i!=0))
		{
			printf ("\n");
		}
	} 
	printf ("\n");	
	
	return 0;
}
