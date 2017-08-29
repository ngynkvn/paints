# Paints
A java application I created that creates images based on implementations I give it. 
It was inspired by this [StackExchange thread](https://codegolf.stackexchange.com/questions/22144/images-with-all-colors). 
This was a fun challenge which gave me an excuse to take up and attempt to surmise my own take on generating images. 
The program creates 256x256 images containing the full range of 16-bit color using a given algorithm. I've included some examples,
including my failures as I was learning file i/o and debugging. (The only good looking one is nearest.png which was generated using the NearestNeighbor code found in src/main/java/algorithms, the rest are pretty bad.)

## TODO
1. Create a better arguments handler that detects --flags and such. [could use a library but this would be fun to implement myself]
2. Establish a better interface for algorithms? Study more OO
3. Solve the problem of "playback", how can I replay the exact order of pixels placed in the app?
    * Have a flag so that if true, write output to a .txt file that can be read by the application

---
## Usage
```
java Paints [fileOutputName] [algorithm]
```
For now I've only implemented two different ways to generate images, `lazy` and `nearest`. I plan on adding more later on.
