package newSort;

public class Stack {

	private int STACK_INIT_SIZE = 10;//ջ��ԭʼ��С
    private int INCREMENT =1;//ջ��������С
    
    private Object []Stack = null;
    private int base;
    private int top;
    private int stacksize;
    
  
    public Stack()
    {
	   Stack = new Object[STACK_INIT_SIZE];
       base=0;
       top=0;
       stacksize=0;
    }
     
    /**
     * ��ջ
     * */
   public void push(Object o)
    {
        if(top-base>=STACK_INIT_SIZE)
        {
            System.out.println("Extended stack");//����ջ
            STACK_INIT_SIZE=STACK_INIT_SIZE+INCREMENT;
            Object []temp = new Object[STACK_INIT_SIZE];
            for(int i=0;i<stacksize;i++)
            {
                temp[i]=Stack[i];
            }
            Stack=null;
            Stack=temp;
        }
        Stack[stacksize] = o;
        stacksize++;
        top++;
    }
    /**
     * ��ջ
     * */
   public Object pop()
    {
        Object o = null;
        if(top==base)
        {
            System.out.println("There is no element in the stack, Return null !");//ջ��û��Ԫ�أ�����null
        }else
        {
            o=Stack[--top];
            stacksize--;
        }
        return o;
    }
     
    /**
     * ȡջ��Ԫ��
     * */
/*   public Object getTop()
    {
        Object o = null;
        if(top==base)
        {
            System.out.println("There is no element in the stack, Return null !");
        }else
        {
            o=Stack[top-1];
        }
        return o;
    }      */
     
    /**
     * ��ӡջ
     * */
/*   public void print()
    {
        System.out.print("��ӡջ��");
        for(int i=0;i<stacksize;i++)
        {
            System.out.print(Stack[i]+"\t");
        }
        System.out.println();
    }    */
	
}
    