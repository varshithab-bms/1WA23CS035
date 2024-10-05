#include<stdio.h>
void push(int stack[],int data,int *top,int n);
int pop(int stack[],int *top);
void display(int stack[],int *top);
int main()
{
int n,data,value,choice;
int top=-1;
printf("\nenter the size of the array:\n");
scanf("%d",&n);
int stack[n];
printf("options");
printf("1.push\n");
printf("2.pop\n");
printf("3.display\n");
printf("4.exit\n");
do{
printf("\nenter your choice:\n");
scanf("%d",&choice);

switch(choice)
{
case 1:
printf("enter the value to be pushed:\n");
scanf("%d",&data);
push(stack,data,&top,n);
break;

case 2:
value = pop(stack,&top);
if (value != -1) {
printf("the deleted element is %d",value);
}
break;

case 3:
display(stack,&top);
break;

case 4:
    return 0;
default:
printf("enter a valid choice");
}
}while(choice!=4);

}

void push(int stack[],int data,int *top,int n)
{
if(*top>=n-1){
printf("\n\t stack is overflow");
}
else{
*top=*top+1;
stack[*top]=data;
}
}
int pop(int stack[],int *top)
{
if(*top<=-1){
printf("underflow");
return -1;
}
else{
int del=stack[top];
*top=*top-1;
return del;
}
}
void display(int stack[],int *top)
{
if(*top>=0){
printf("the elements in the stack");

for(int i=*top;i>=0;i--){
printf("\n%d",stack[i]);
}
}
else{
printf("\n the stack is empty");
}
}
