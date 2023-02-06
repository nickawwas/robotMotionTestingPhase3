class Robot {
	byte direction;
	private boolean penIsDown;
	int[] coordinates = {0,0};
	boolean[][] boardState;

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
	/* A bit hard to explain, but essentially, we just need a 2-bit unsigned
	 * number to represent the direction of the robot.
	 * 00 is north, 01 is east, 10, is south, and 11 is west.
	 * If we add or subtract 1 whenever we turn, we will go between states
	 * seamlessly as 11 goes back to 00 when we add 1.
	 * Java doesn't have 2-bit-unsigned numbers, but the modulus 4 does the job.
	 */
	// Command R|r
	public void turnLeft() {
		this.direction = (byte) ((this.direction - 1) % 4);
	}
	// Command L|l
	public void turnRight() {
		this.direction = (byte) ((this.direction + 1) % 4);
	}
	// Command M s|m s
	// TODO: add a check
	public void move(int s) throws Exception {
		switch (this.direction) {
			// facing north
			case 0 -> {
				if (this.coordinates[0] + s > this.boardState.length) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[0]++;
						markBoard();
						s--;
					}
				}
			}
			// facing east
			case 1 -> {
				if (this.coordinates[1] + s > this.boardState.length) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[1]++;
						markBoard();
						s--;
					}
				}
			}
			// facing south;
			case 2 -> {
				if (this.coordinates[0] - s > this.boardState.length) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[0]--;
						markBoard();
						s++;
					}
				}
			}
			// facing west;
			case 3 -> {
				if (this.coordinates[1] - s > this.boardState.length) {
					throw new Exception("Movement request would make the robot fall off the board.");
				} else {
					while (s > 0) {
						this.coordinates[1]--;
						markBoard();
						s++;
					}
				}
			}
		}
	}

	// Command P|p
	void printBoard() {
		for(int i = 0; i < this.boardState.length; i++) {
			for(int j = 0; j < this.boardState.length; j++) {
				//System.out.print(i + "\t");
				if(this.coordinates[0] == i && this.coordinates[1] == j){
					if (this.direction == 0) {
						System.out.print("N" + '\t');
					} else if (this.direction == 1) {
						System.out.print("E"+ '\t');
					} else if (this.direction == 2) {
						System.out.print("S"+ '\t');
					} else if (this.direction == 3) {
						System.out.print("W"+ '\t');
					}
				}
				else if (this.boardState[i][j]) {
					System.out.print("*"+ '\t');
				} else {
					System.out.print("."+ '\t');
				}
			}
			System.out.print("\n");
		}
	}

	// Command C|c
	// Not sure if this will work or not to be honest
	public void currentStateOfTheRobot() {
		System.out.print("Position: " + this.coordinates[0] + ", " + this.coordinates[1] + " - Pen: ");
		if (this.penIsDown) {
			System.out.print("down");
		} else {
			System.out.print("up");
		}
		System.out.print(" - Facing: ");
		if (this.direction == 0) {
			System.out.println("north");
		} else if (this.direction == 1) {
			System.out.println("east");
		} else if (this.direction == 2) {
			System.out.println("south");
		} else if (this.direction == 3) {
			System.out.println("west");
		}
	}

	private void markBoard() {
		if (this.penIsDown) {
			this.boardState[this.coordinates[0]][this.coordinates[1]] = true;
		}
	}
}