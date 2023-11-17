#include <stdio.h>

int main(int argc, char *argv[]) {
	
	int a,b,c,d;
	
	a=6;
	b=8;
	c=0;
	d=0;
	
	printf ("La primera variable tiene el valor de %d\n",a);
	printf ("La segundo variable tiene el valor de %d\n",b);
	c=a+b;
	printf ("La suma de estas variables tiene el valor de %d\n",c);
	if (a>=b)
		d=1;
	else
		d=0;
	printf ("Si la primera variable es mayor que la segunda aparecerá un 1 y si no un 0:  %d\n",d);
	printf ("\n");
	a++;
	b--;
	
	printf ("La primera variable +1 tiene el valor de %d\n",a);
	printf ("La segundo variable -1 tiene el valor de %d\n",b);
	c=a+b;
	printf ("La suma de estas variables tiene el valor de %d\n",c);
	if (a>=b)
		d=1;
	else
		d=0;
	printf ("Si la primera variable es mayor que la segunda aparecerá un 1 y si no un 0:  %d\n",d);
	printf ("\n");
	
	a=a+5;
	b=b-3;
	
	printf ("La primera variable +1 y +5 tiene el valor de %d\n",a);
	printf ("La segundo variable -1 y -3 tiene el valor de %d\n",b);
	c=a+b;
	printf ("La suma de estas variables tiene el valor de %d\n",c);
	if (a>=b)
		d=1;
	else
		d=0;
	printf ("Si la primera variable es mayor que la segunda aparecerá un 1 y si no un 0:  %d\n",d);
	printf ("\n");
	
	return 0;
}

