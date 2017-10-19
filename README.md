# CommandLineWindow

My attempt at making a command line window that could run commands on a project it was implimented in.

Features I would like to all eventually work.  
- Be able to set/get global variables of a class
  - numIterations = `5`; ->  `var -v numIterations -s 5`
  - defaultFontName = `"Times New Roman"`; -> `var -v defaultFontName -s Times New Roman`
  - int x = `numIterations`; -> `var -v numIterations -g`
- Be able to run methods of a class
  - System.out.println(`stringToPrint`); -> `var -v stringToPrint -p`
  - printToConsole(`stringToPrint`); -> `var -v stringToPrint -c`
  - graphics.fillRect(`x`, `y`, `w`, `h`); -> `fillRect -x 50 -y 50 -w 15 -h 25`
- Be able to interact with the 3 `ScrollPane`s, and "send information" from one to the other
  - Ex: Run some data and get the list of summaries in the top left, and then run a command to print the full data to the big window
- Have a system with predefined "commands", but also be able to easily design custom commands specific to the project at hand,
therefore making it useful for simply importing it, adding a few commands, and being able to more easily debug your program than
running it over and over again and keep changing things
