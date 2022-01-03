package homework6;

import java.util.StringTokenizer;

public class Instruction {
	private String line;
	private String opcode;
	private String operand [] = new String [2];
	public Instruction(String line) {
		this.line = line;
		line = line.toUpperCase(); 
		StringTokenizer st = new StringTokenizer(line);
		
		opcode = st.nextToken(); 
		operand[0] = st.nextToken(); 
		operand[1] = st.nextToken(); 
	}
	
	public String getOpcode() {
		return opcode;
	}
	
	public String getOperand(int index) {
		if(index < 0 || index > 2)
			return null;
		return operand[index];
	}
	
	public String toString() {
		return "[" + line + "] ";
	}
}