package newSort;

public class Stack {

	private int STACK_INIT_SIZE = 10;//栈的原始大小
    private int INCREMENT =1;//栈的增量大小
    
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
     * 入栈
     * */
   public void push(Object o)
    {
        if(top-base>=STACK_INIT_SIZE)
        {
            System.out.println("Extended stack");//扩充栈
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
     * 出栈
     * */
   public Object pop()
    {
        Object o = null;
        if(top==base)
        {
            System.out.println("There is no element in the stack, Return null !");//栈中没有元素！返回null
        }else
        {
            o=Stack[--top];
            stacksize--;
        }
        return o;
    }
     
    /**
     * 取栈顶元素
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
     * 打印栈
     * */
/*   public void print()
    {
        System.out.print("打印栈：");
        for(int i=0;i<stacksize;i++)
        {
            System.out.print(Stack[i]+"\t");
        }
        System.out.println();
    }    */
	
}
    