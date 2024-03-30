package src.Modes;

import src.Components.Canvas;

public interface Mode {
    void activate(Canvas canvas);
    void deactivate(Canvas canvas);
}
