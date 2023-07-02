package ru.tododecider.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class PriorityLogic {
    public final static boolean useWaiting = true;
    public static IntSupplier getNewPriority(){
        return () -> new Random().nextInt(20);
    }

    public static IntUnaryOperator useWaitingInPriority(){
        return useWaiting ?
                x -> -x : //чем дольше таска в очереди, тем раньше ее надо отдать => снижаем приоритет
                x -> 0;
    }
}
