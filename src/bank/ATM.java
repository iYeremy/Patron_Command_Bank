package bank;

import commands.Command;
import java.util.Stack;

public class ATM{
	
	private Stack<Command> history = new Stack<>(); 

	public void executeOP(Command command){
		command.execute();
		history.push(command);
	}

	public void undoOP(Command command){
		if(!history.isEmpty()){
			command.undo();
			history.pop();
		}	else {
			System.out.println("Action not available: cannot be reversed");
		}
	}
	
}
