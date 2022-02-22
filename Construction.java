package greadedProject3Q1;

import java.util.Stack;

public class Construction {


		Stack<Integer> stack, 

		temp_stack;

		int [] floorDay;
		int floors;

		public Construction() {
			stack = new Stack<>();
			temp_stack = new Stack<>();
		}


		public void display() {


			System.out.println("The order of construction is as follows -: ");

			int presentFloor = floors; 

			for(int i = 1; i <= floors; i++) {

				System.out.println("\nDay: " + i);

				while(presentFloor > 0 && floorDay[presentFloor-1] == i) {

					System.out.print(presentFloor-- + " ");

				}
			}
		}

		public void CunstrucionCalculation(int floors, int floorSizes[]) {

			this.floors = floors;

			floorDay = new int[floors];

			stack.clear();

			int presentFloor = floors;

			for(int i = 1; i <= floors; i++) {

				if(floorSizes[i-1] == presentFloor) {

					floorDay[presentFloor-1] = i;

					presentFloor--;

				} else {

					floorinsertion(floorSizes[i-1]);

				}

				presentFloor = floorSizes(presentFloor, i);

			}

		}


		private void floorinsertion(int size) {

			while(!stack.isEmpty() && stack.peek() > size) {

				int element = stack.pop();

				temp_stack.push(element);

			}

			stack.push(size);

			while(!temp_stack.isEmpty()) {

				stack.push(temp_stack.pop());

			}

		}


		private int floorSizes(int presentFloor, int day) {

			while(!stack.isEmpty() && stack.peek() == presentFloor) {

				floorDay[presentFloor-1] = day;

				presentFloor--;

				stack.pop();

			}

			return presentFloor;
		}


		public void ConstructAlgo(int n, int[] floorSizes) {
			// TODO Auto-generated method stub
			
		}




	}
