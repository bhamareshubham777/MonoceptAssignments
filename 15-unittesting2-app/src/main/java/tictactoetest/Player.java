package tictactoetest;

public class Player {

	private String name;
	 private MarkType mark;

	 Player(String name, MarkType mark) {
	     this.name = name;
	     this.mark = mark;
	 }

    String getName() {
	     return name;
	 }

	 MarkType getMark() {
	     return mark;
	 }
}
