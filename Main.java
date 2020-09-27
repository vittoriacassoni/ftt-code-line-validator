import java.util.Stack;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try{
      System.out.println("Digite o conjunto de simbolos que deseja validar (Digite apenas { [ ( < > ) ] }");
      Scanner read = new Scanner(System.in);
      String symbols = read.nextLine();

      if(isValid(symbols)){
        System.out.println("Conjunto válido!");
      } else{
        System.out.println("Conjunto inválido!");
      }
    }catch(Exception error){
      System.out.println(error);
    }
  }

  static boolean isValid(String set){
    Stack<Character> stackOpenings = new Stack();
    for(int i = 0; i < set.length(); i++){
      if(!isValidChar(set.charAt(i))){
        System.out.println("Um simbolo não faz parte do alfabeto");
        return false;
      }
      if(isOpen(set.charAt(i))){
        stackOpenings.push(set.charAt(i));
      }else{
        if(stackOpenings.isEmpty()){
          return false;
        }
        if(isNotAPairOfSymbol(set.charAt(i), stackOpenings.peek())){
          return false;
        }
        stackOpenings.pop();
      }
    }
    return stackOpenings.isEmpty();
  }

  static boolean isValidChar(char symbol){
    return symbol == '{' || symbol == '[' || symbol == '(' || symbol == '<' || symbol == '}' || symbol == ']' ||      symbol == ')' || symbol == '>';
  }

  static boolean isOpen(char symbol){
    return symbol == '{' || symbol == '[' || symbol == '(' || symbol == '<';
  }

  static boolean isNotAPairOfSymbol(char symbolClosed, char symbolOpened){
    return symbolClosed == '}' && symbolOpened != '{' || symbolClosed == ']' && symbolOpened != '[' || symbolClosed == ')' && symbolOpened != '(' ||symbolClosed == '>' && symbolOpened != '<';
  }
}