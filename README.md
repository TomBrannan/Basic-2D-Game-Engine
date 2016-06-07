# Basic-2D-Game-Engine
A rudimentary 2D game engine in Java.  Provides a simple abstract game loop and input (keyboard and mouse) functionality.  Also includes a basic Java Swing implementation.
![Game Engine](http://i.imgur.com/6WVVGu5.png)

# Usage
The engine package is abstract - the Game and GameLoop classes can be extended to add specific graphics/audio/input implementations.  The GameLoop class acts as the real "engine" which plays a Game object.  A Swing implementation is given as an example (in the engine.swing package), which can be extended for an actual Swing game instance.  The included "game" in the gameimpl package
showcases a background, particle engine, moving sprite, and mouse input.  
