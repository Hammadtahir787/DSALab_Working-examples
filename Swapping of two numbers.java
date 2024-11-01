class Swap{
    int a;
    int b;
    Swap(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void swap(){
        a = a+b;
        b = a-b;
        a = a-b;
    }
    public void display(){
        System.out.println("a = "+a+"\n"+"b = "+b);
    }
    public static void main(String[] args){
        Swap obj = new Swap(50,80);
        System.out.println("Before Swapping:");
        obj.display();

        obj.swap();

        System.out.println("After swapping: ");
        obj.display();
    }
}