package com.example.lab1.entity;

import com.example.lab1.core.Habitat;
import com.example.lab1.view.RabbitController;
import javafx.scene.image.Image;

import java.util.Random;

public class DefaultRabbit extends Rabbit {
    //private static final Image image = new Image("C:\\Users\\maxsp\\IdeaProjects\\lab1\\src\\main\\resources\\assets\\default_rabbit.jpg");
    private static final Image image = new Image(System.getProperty("user.dir") + "\\src\\main\\resources\\assets\\default_rabbit.jpg");
    public static int count = 0;
    private double x;
    private double y;
    private double speed = 200.0 / RabbitController.FPS;
    private Direction direction;
    private final int birthTime;
    private final int lifeTime;
    private final int id;
    private final int size = 50;
    private final int changeDirectionEach = 5;

    public DefaultRabbit(int birthTime, int lifeTime, int id) {
        count++;
        Random random = new Random();
        x = random.nextInt(Habitat.getWidth() - size);
        y = random.nextInt(Habitat.getHeight() - size);
        this.birthTime = birthTime;
        this.lifeTime = lifeTime;
        this.id = id;
        this.direction = Direction.getRandomDirection();
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void updateDirection() {
        if (Habitat.getInstance().getSimulationTime() % changeDirectionEach == 0) {
            setDirection(Direction.getRandomDirection());
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getBirthTime() {
        return birthTime;
    }

    @Override
    public int getLifeTime() {
        return lifeTime;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void die() {
        count--;
    }

    @Override
    public String toString() {
        return birthTime + " - Default Rabbit";
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
