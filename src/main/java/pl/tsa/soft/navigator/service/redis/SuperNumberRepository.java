/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tsa.soft.navigator.service.redis.entity.SuperNumberEntity;

/**
 *
 * @author potatolot
 */
@Repository
public interface SuperNumberRepository extends CrudRepository<SuperNumberEntity, String> {

}
