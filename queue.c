#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define MAX 10
int queue[MAX];
void insert(int *front,int *rear);
int delete(int *front,int *rear);
void display(int *front,int *rear);
int main()
{
  int front,rear,option,val;
  front=rear=-1;
  do{
     printf("\n***OPTIONS***\n");
     printf("1.Insert\n");
     printf("2.Delete\n");
     printf("3.Display\n");
     printf("4.Exit\n");
     printf("Enter your option:\n");
     scanf("%d",&option);

     switch(option){
        case 1: insert(&front,&rear);
               break;

        case 2: val = delete(&front,&rear);
                if(val!=-1){
                    printf("%d deleted sucessfully\n",val);
                }
               break;

        case 3: display(&front,&rear);
               break;
        case 4: printf("Exiting...\n");
        break;
        
        }

        }while(option!=4);
        return 0;
     }
     
     
void insert(int *front,int *rear){
    int num;
    printf("Enter the value to insert:\n");
    scanf("%d",&num);
    if (*rear==MAX-1)
    {
        printf("Queue overflow"); exit(1);
    }
    else if (*front==-1 && *rear==-1)
    {  *front=*rear=0;
    }
    else{
        *rear=*rear+1;
    }
    queue[*rear]=num;
    }
    
int delete(int *front,int *rear)
{
     int val;
     if (*front==-1 )
     {
       printf("Queue underflow\n");
       return -1;
     }
     else
     {
      val=queue[*front];
      if (*front == *rear) 
      {
            *front = *rear = -1;}
      else{
      (*front)++;
     }
     return val;
     }
}

void display(int *front,int *rear)
{
 if (*front==-1 ){
   printf("Queue is empty\n");
 }
  else{
        printf("Queue elements: ");
        for (int i=*front;i<=*rear;i++)
        {
         printf("%d\t",queue[i]);
        }
   }
 }

