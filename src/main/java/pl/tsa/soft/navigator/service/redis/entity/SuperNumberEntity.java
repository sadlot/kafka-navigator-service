/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.redis.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author potatolot
 */
@RedisHash("SuperNumber")
public class SuperNumberEntity implements Serializable {

    @Id
    private String id;

    private int number;

    private long timestamp;

    private String owner;

    public SuperNumberEntity() {
    }

    public SuperNumberEntity(int number) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuperNumber{" + "number=" + number + ", timestamp=" + timestamp + ", owner=" + owner + ",id=" + id + '}';
    }

}
