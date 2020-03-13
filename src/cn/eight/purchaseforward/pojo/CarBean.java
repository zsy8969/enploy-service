package cn.eight.purchaseforward.pojo;

import cn.eight.purchaseforward.service.GoodService;
import cn.eight.purchaseforward.service.impl.GoodServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarBean {
    //定义一个属性存放购物车的关键数据
    Map<Integer,Integer> car;

    public Map<Integer, Integer> getCar() {
        return car;
    }

    public void setCar(Map<Integer, Integer> car) {
        this.car = car;
    }

    //添加商品
    public void addGood(Integer id){
        if (car == null){
            car = new HashMap<>();
        }
        car.put(id,1);
    }

    //清空购物车
    public void clearCar(){
        if (car!=null){
            car.clear();
        }
    }

    //删除商品
    public void removeGood(Integer id){
        if (car != null){
            car.remove(id);
        }
    }

    //更新商品
    public void modGood(Integer[] ids,Integer[] amounts){
        for (int i = 0; i < ids.length; i++) {
            car.put(ids[i],amounts[i]);
        }
    }

    //得到购物车中商品的总数量
    public Integer getAmounts(){
        int amounts = 0;
        if (car!=null){
            for (Map.Entry<Integer,Integer> entry:car.entrySet()) {
                amounts+=entry.getValue();
            }
        }
        return amounts;
    }

    //得到购物车的总金额
    public Integer getBlance(){
        int blance = 0;
        GoodService service = new GoodServiceImpl();
        List<Good> cars = service.findCars(this);
        for (int i = 0; i < cars.size(); i++) {
            blance+=cars.get(i).getAmount() * cars.get(i).getPrice();
        }
        return blance;
    }
}
