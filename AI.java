public interface AI {
    boolean located();
    void setLocated(boolean located);

    void setPositionX(int positionX);
    void setPositionY(int positionY);

    int getPositionY();
    int getPositionX();

    int getDirection();
    void setDirection(int direction);


}
