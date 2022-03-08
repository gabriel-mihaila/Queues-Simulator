# Queues-Simulator
The application should simulate (by defining a simulation time T𝑠𝑖𝑚𝑢𝑙𝑎𝑡𝑖𝑜𝑛) a series of N clients  arriving for service, entering Q queues, waiting, being served and finally leaving the queues. 

All clients are generated when the simulation is started, and are characterized by three parameters: ID (a number between 1 and N), T𝑎𝑟𝑟𝑖𝑣𝑎𝑙 (simulation timewhen they are ready to go to the queue; i.e. time when the client finished shopping) and T𝑠𝑒𝑟𝑣𝑖𝑐𝑒 (time interval or duration needed to serve the client; i.e. waiting time when the client is in front of the queue). The application tracks the total time spent by every client in the queues and computes the average waiting time. Each client is added to the queue with minimum waiting time when its T𝑎𝑟𝑟𝑖𝑣𝑎𝑙 time is greater than or equal to the simulation time (T𝑎𝑟𝑟𝑖𝑣𝑎𝑙 ≥ T𝑠𝑖𝑚𝑢𝑙𝑎𝑡𝑖𝑜𝑛).

https://user-images.githubusercontent.com/72153726/157253455-99d9f5b3-df4c-4cc6-834d-3a67483e6cdc.mp4


