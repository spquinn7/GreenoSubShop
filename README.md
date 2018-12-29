# GreenoSubShop
Trying to make an algorithm that will tell the workers of an on campus sub shop what order to make sandwiches in order to minimize total wait time for customers. Implemented with a Queue. The main two distinctions that are to note are that there are sandwiches made for call in order (pickup), and some that are made for people in person.

What it does: disperses the sandwiches into the queue based on whether or not they are pickup or not. So, instead of making everything in a straight line, sandwiches for people in house are prioritized. Here is an example of how this makes the process faster (lets assume every sandwich is made in 5 minutes, one after the other):


Traditional straight line approach:
Customer 1 (in house) orders 1 sandwich at 9:00 AM, it is finished at 9:05 AM (5 min wait time)
Customer 2 (pickup) orders 4 sandwiches at 9:01 AM, starts at 9:05 finishes at 9:25 (24 min wait time)
Customer 3 (in house) orders 1 sandwich at 9:02 AM, starts at 9:25 finishes at 9:30 (28 min wait time)

Total Wait time: 57 minutes

Algorithms Approach:
Customer 1 (in house) orders 1 sandwich at 9:00 AM, it is finished at 9:05 AM (5 min wait time)
Customer 2 (pickup) orders 4 sandwiches at 9:01 AM, 
Customer 3 (in house) orders 1 sandwich at 9:02 AM, puts this in the queue after the first pickup sandwich is made.


Customer 1 sandwich 9 - 9:05 (5 min wait time)
customer 2 sandwich1 9:05 - 9:10
customer 3 sandwich 9:10 - 9:15 (13 min wait time)
customer 2 sandwiches2-4 9:15-9:30  (28 min wiat time)

Total wait time: 46 minutes 
