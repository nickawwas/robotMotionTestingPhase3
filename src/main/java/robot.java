class Robot {
	private int direction;
	private boolean penIsDown;
	private int[] coordinates = {0,0};
	private boolean[][] boardState;

	public Robot(int n) {
		this.direction = 0;
		this.penIsDown = false;
		this.boardState = new boolean[n][n];
	}
	// Command U|u
	public void setPenUp() {
		this.penIsDown = false;
	}
	// Command D|d
	public void setPenDown() {
		this.penIsDown = true;
		markBoard();
	}
	public boolean getPenIsDown(){
		return this.penIsDown;
	}

	// Command R|r
	public int turnLeft() {
		this.direction = (this.direction + 3) % 4;
		return this.direction;
	}
	// Command L|l
	public int turnRight() {
		this.direction = (this.direction + 1) % 4;
		return this.direction;
	}
	// Command M s|m s

	public int[] move(int s) throws Exception {
		switch (this.direction) {
			// facing north
			case 0 -> {
				if (this.coordinates[1] + s > this.boardState.length - 1) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[1]++;
						markBoard();
						s--;
					}
				}
			}
			// facing east
			case 1 -> {
				if (this.coordinates[0] + s > this.boardState.length - 1) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[0]++;
						markBoard();
						s--;
					}
				}
			}
			// facing south;
			case 2 -> {
				if (this.coordinates[1] - s < this.boardState.length - 1) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[1]--;
						markBoard();
						s++;
					}
				}
			}
			// facing west;
			case 3 -> {
				if (this.coordinates[0] - s < this.boardState.length - 1) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[0]--;
						markBoard();
						s++;
					}
				}
			}
		}
		return this.coordinates;
	}

	// Command P|p
	public String printBoard() {
		String board = "";
		for(int i = this.boardState.length - 1; i >= 0; i--) {
			for(int j = 0; j < this.boardState.length; j++) {
				if(this.coordinates[1] == i && this.coordinates[0] == j){
					if (this.direction == 0) {
						board = board + "↑\t";
					} else if (this.direction == 1) {
						board = board + "→\t";
					} else if (this.direction == 2) {
						board = board + "↓\t";
					} else if (this.direction == 3) {
						board = board + "←\t";
					}
				}
				else if (this.boardState[i][j]) {
					board = board + "*\t";
				} else {
					board = board + ".\t";
				}
			}
			board = board + "\n";
		}
		return board;
	}

	// Command C|c
	public String currentStateOfTheRobot() {
		String state;
		state = "Position: " + this.coordinates[0] + ", " + this.coordinates[1] + " - Pen: ";
		if (this.penIsDown) {
			state = state + "Down";
		} else {
			state = state + "Up";
		}
		state = state + " - Facing: ";
		if (this.direction == 0) {
			state = state + "North";
		} else if (this.direction == 1) {
			state = state + "East";
		} else if (this.direction == 2) {
			state = state + "South";
		} else if (this.direction == 3) {
			state = state + "West";
		}
		return state;
	}

	private void markBoard() {
		if (this.penIsDown) {
			this.boardState[this.coordinates[1]][this.coordinates[0]] = true;
		}
	}
}