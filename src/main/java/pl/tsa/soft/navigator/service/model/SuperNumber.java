/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.model;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author potatolot
 */

public class SuperNumber implements Serializable {

    private int number;

    private long timestamp;

    private String owner;

    public SuperNumber() {
    }

    public SuperNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "SuperNumber{" + "number=" + number + ", timestamp=" + timestamp + ", owner=" + owner + '}';
    }

}
