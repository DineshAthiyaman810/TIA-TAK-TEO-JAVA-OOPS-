import java.util.Scanner;
/** 
 * Disaly fiunction is used to disaply board and it used to cheak the condition 
 * in the game if the person is win it return w or if the match is draw then it retur d for 
 * represent the game is draw and last function is cls used to like system cls in java we used ascii number 
 */
class display {
    /**it a function used to clear the screen and 
     * System.out.println("\033[H\033[2J");
        System.out.flush(); 
        we can only use in function
        **/
    public  static void cls(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
         }
    protected char result = 'z';
    protected  static char board[] ={'0','1','2','3','4','5','6','7','8','9'};
    public static void Display()
    {
     System.out.println(board[1] + " | " + board[2] + " | " + board[3] );
     System.out.println( "_" + " | "+ "_" + " | "+ "_");
     System.out.println(board[4] + " | " + board[5] + " | " + board[6] );
     System.out.println( "_" + " | "+ "_" + " | "+ "_");
     System.out.println(board[7] + " | " + board[8] + " | " + board[9] );
    }

    /** 
     * this function used to cheak the game if person is win or loss
     * if person is win it return 'w'
     * if the game is draw it return 'd' 
     * if the game is not end then it return 'z'
     */
    public  void condition()
    {
    	if(board[1]==board[2]&&board[1]==board[3] || board[4]==board[5]&&board[4]==board[6] || board[7]==board[8]&&board[7]==board[9])
	result='w';
	else if(board[1]==board[4]&&board[1]==board[7] ||board[2]==board[5]&&board[2]==board[8] ||board[3]==board[6]&&board[3]==board[9] )
    result='w';
       else if(board[1]==board[2] &&board[1]==board[9] || board[3]==board[5] &&board[3]==board[7])
        result='w';
       else if(board[1]!='1' && board[2]!='2' && board[3]!='3' && board[4]!='4' && board[5]!='5' && board[6]!='6' && board[7]!='7'&& board[8]!='8'&& board[9]!='9')
	result='d';
	else 
	result='z';
    }

}
/**
 * playersplayer has one functionname called  selectplayer used to select player 
 * selectplayer method used to selet player and used to select position and helps to updated the position

 */
class playervsplayer extends display{
    Scanner in = new Scanner(System.in);
    private int opt;
    public int player =1;
    public char symbol;
    /**
     * this fucction used to selct player and select symbol according to the player 
     * if the player is 1 then it select 'x'
     * if the player is 2 then it select 'y'
     * then  it call the condition method in super class for the result
     * if result is 'w' or 'z' them it will return  to main method if the result is z i will continue 
     */
    public void selectplayer()
    {
    
    do
    {
        Display();
    player = player%2==0? 2: 1;
    symbol = (player==1)? 'x' : 'y';
    System.out.println("player " + player + "Select your Place " + " with " + symbol);
    opt =in.nextInt();
   if(board[opt]=='x' || board[opt]=='y')
    {
    System.out.println("enter vaild position");
        
        selectplayer();
    }
    else{
        cls();
        board[opt] = symbol;
        player++;
        super.condition();
        
    }
    }while(result=='z');
}
}
class tik{

    
    public static void main(String[] args) {
        int option;
        Scanner in = new Scanner(System.in);
        playervsplayer obj = new playervsplayer();
        System.out.println("Welcome To TIK TAK TEO GAME ");
        do{
            System.out.println("Enter Opton  \n 1.PLAYER VS PLAYER \n 2.EXIT" );
                option = in.nextInt();
            switch(option)
            {
                case 1:
                
                obj.selectplayer();
                
                break;
                case 2:
                
               System.out.println("Thanks for your participation");
                break;
                default:
                System.out.println("Enter Vaild Option ");
                obj.cls();
            }
            if(obj.result=='w' && obj.player==1)
            {
                System.out.println("Player  2 won ");
                obj.Display();
                
            }
            else if(obj.result=='w' && obj.player==2)
            {
                System.out.println("Player  1 won ");
                obj.Display();


            }
            else if (obj.result =='d')
            {
                System.out.println("mathc draw");
                obj.Display();
            }
        }while(option!=2);
       
        

    }
    
}