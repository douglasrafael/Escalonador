package so.escalonador.uepb;

//programming FCFS scheduling algorithm

import java.util.*;

public class Testes
{
public static void main(String[] args)
{
 Scanner input = new Scanner(System.in);

 int index = 1;
 ArrayList<Task> tasks = new ArrayList<Task>(); // storage for the tasks
 while (input.hasNextInt())            // read CPU burst times of tasks 
 { 
   int burst = input.nextInt();
   tasks.add(new Task(index, burst));  // add a new task to the array
   index++;
 }    
 int numTasks = tasks.size();          // total # of tasks

 int waitingTime = 0;                  // waiting time in a queue
 int time = 0;                         // CPU time
 System.out.print("0");
 while (! tasks.isEmpty())             // take the tasks in the natural order
 {                                     // and throw them into the schedule
   Task t = tasks.remove(0);
   if (! tasks.isEmpty())
     waitingTime += waitingTime + t.burst;
   time += t.burst;
   System.out.print(" - P" + t.index + " - " + time);
 }
 System.out.println("\nAverage waiting time: " + waitingTime + "/" +
   numTasks + " = " + ((1.0*waitingTime)/numTasks));
}
}

class Task
{
public int index;                      // task index
public int burst;                      // task burst time

public Task(int index, int burst)      // task class constructor 
{
 this.index = index;
 this.burst = burst;
}
}