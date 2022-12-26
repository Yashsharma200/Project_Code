package practise.one;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.stream.Collectors;

	public class yash {
		public static void main(String[] args) throws NumberFormatException, IOException {
			File file = new File("C:\\Users\\RITIK\\OneDrive\\Desktop\\Coding_Assignment\\Input.txt");
			File file1 = new File("C:\\Users\\RITIK\\OneDrive\\Desktop\\Coding_Assignment\\Output.txt");
			file1.createNewFile();
			FileWriter writer = new FileWriter(file1);
			System.out.println(file.canExecute());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int noOfJobs = Integer.parseInt(reader.readLine());
			List<Jobs> jobList = new ArrayList<>();
			if (noOfJobs <= 100) {
				for (int i = 0; i < noOfJobs; i++) {
					int Begin = Integer.parseInt(reader.readLine());
					int FinishTime = Integer.parseInt(reader.readLine());
					int Gain = Integer.parseInt(reader.readLine());
					jobList.add(jobDetails(Begin, FinishTime, Gain));
				}
				List<Jobs> filteredList = jobList.stream().filter((e1) -> e1.getStartTime() < e1.getEndTime())
						.collect(Collectors.toList());
				filteredList.remove(filteredList.stream().max((e1, e2) -> e1.getProfit() - e2.getProfit()).get());
				int size = filteredList.size();
				int totalProfit = 0;
				for (int i = 0; i < size; i++) {
					Jobs j = filteredList.get(i);
					totalProfit = totalProfit + j.getProfit();
				}
				int[] arr = { size, totalProfit };
//				System.out.println("No of jobs remaning =" + arr[0]);
				writer.write("Task: "+ arr[0] + "\n Earning: " + arr[1]);
//				System.out.println("Total profit that can be earned by the employee = " + arr[1]);
				writer.close();
				reader.close();

			} else {
				System.out.println("no of Jobs is greater than limit");
			}
		}

		public static Jobs jobDetails(int Begin, int FinishTime, int Gain) {
			Jobs jobs = new Jobs();
			jobs.setStartTime(Begin);
			jobs.setEndTime(FinishTime);
			jobs.setProfit(Gain);
			return jobs;

		}

	}

	class Jobs {
		private int Begin;
		private int FinishTime;
		private int Gain;

		public int getStartTime() {
			return Begin;
		}

		public void setStartTime(int startTime) {
			Begin = startTime;
		}

		public int getEndTime() {
			return FinishTime;
		}

		public void setEndTime(int endTime) {
			FinishTime = endTime;
		}

		public int getProfit() {
			return Gain;
		}

		public void setProfit(int profit) {
			Gain = profit;
		}
	}


