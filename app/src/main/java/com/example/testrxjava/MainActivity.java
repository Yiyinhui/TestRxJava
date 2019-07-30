package com.example.testrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView hello;
    String TAG = "rx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);

        RxJava();
    }

    private void RxJava() {

//        /**
//         * 第一步，创建被观察者。
//         */
//        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.d(TAG, "=========================currentThread name: " + Thread.currentThread().getName());
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        });
//
//
//        /**
//         * 第二步，创建观察者。
//         */
//        Observer observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "======================onSubscribe");
//            }
//
//            @Override
//            public void onNext(Integer integer) {//回调的方法
//                Log.d(TAG, "======================onNext " + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "======================onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "======================onComplete");
//            }
//        };
//
//        /**
//         * 第三步，订阅。被观察者订阅观察者
//         */
//        observable.subscribe(observer);

//        /*
//        链式调用
//         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.d(TAG, "=========================currentThread name: " + Thread.currentThread().getName());
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "======================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {  //发送该事件时，观察者会回调 onNext() 方法
//                        Log.d(TAG, "======================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "======================onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "======================onComplete");
//                    }
//                });

        /**
         * just(),创建一个被观察者，并发送事件，发送的事件不可以超过10个。
         */
//        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "=================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "=================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "=================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "=================onComplete ");
//                    }
//                });

        /**
         * fromArray().和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组。
         */
//        Integer array[] = {1, 2, 3, 4};
//        Observable.fromArray(array)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "=================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "=================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "=================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "=================onComplete ");
//                    }
//                });

        /**
         * fromCallable(),和 Runnable 的用法基本一致，只是它会返回一个结果值，这个结果值就是发给观察者的。
         */
//
//        Observable.fromCallable(new Callable<Integer>() {
//
//            @Override
//            public Integer call() throws Exception {
//                return 1;
//            }
//        })
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "================accept " + integer);
//                    }
//                });

        /**
         * fromFuture(), Future 的作用是增加了 cancel() 等方法操作 Callable，它可以通过 get() 方法来获取 Callable 返回的值。
         */
//        final FutureTask< String > futureTask = new FutureTask < > (new Callable < String > () {
//            @Override
//            public String call() throws Exception {
//                Log.d(TAG, "CallableDemo is Running");
//                return "返回结果";
//            }
//        });
//
//        Observable.fromFuture(futureTask)
//                .doOnSubscribe(new Consumer < Disposable > () {//doOnSubscribe() 的作用就是只有订阅时才会发送事件，具体会在下面讲解。
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        futureTask.run();
//                    }
//                })
//                .subscribe(new Consumer < String > () {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        Log.d(TAG, "================accept " + s);
//                    }
//                });
        /**
         * fromIterable(), 直接发送一个 List 集合数据给观察者
         */
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        Observable.fromIterable(list)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "=================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "=================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "=================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "=================onComplete ");
//                    }
//                });


        /**
         * defer(), 这个方法的作用就是直到被观察者被订阅后才会创建被观察者。
         */
        // i 要定义为成员变量
//         Integer i = 100;
//        final Integer finalI = i;
//        Observable<Integer> observable2 = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
//            @Override
//            public ObservableSource<? extends Integer> call() throws Exception {
//                return Observable.just(finalI);
//            }
//        });
//
//        i = 200;
//
//        Observer observer2 = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG, "================onNext " + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//        observable2.subscribe(observer2);
//
//        i = 300;
//
//        observable2.subscribe(observer2);


        /**
         * timer(),当到指定时间后就会发送一个 0L 的值给观察者。
         */
//        Observable.timer(5, TimeUnit.SECONDS)//延时5s
//                .subscribe(new Observer < Long > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "===============onSubscribe " );
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "===============onNext " + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * interval(),每隔一段时间就会发送一个事件，这个事件是从0开始，不断增1的数字。
         */
//        Observable.interval(4, TimeUnit.SECONDS)
//                .subscribe(new Observer < Long > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==============onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "==============onNext " + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * intervalRange(), 可以指定发送事件的开始值和数量，其他与 interval() 的功能一样。
         */
        Observable.intervalRange(2, 5, 2, 1, TimeUnit.SECONDS)
                .subscribe(new Observer < Long > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==============onSubscribe ");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "==============onNext " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "==============onComplete " );
                    }
                });

        /**
         * range(), 同时发送一定范围的事件序列。
         */
//        Observable.range(2, 5)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==============onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer aLong) {
//                        Log.d(TAG, "==============onNext " + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==============onComplete " );
//                    }
//                });

        /**
         * rangeLong(), 作用与 range() 一样，只是数据类型为 Long
         */

        /**
         * empty() & never() & error()
         *
         * empty()：直接发送 onComplete() 事件
         * never()：不发送任何事件
         * error()：发送 onError() 事件
         *
         * onSubscribe()方法依然调用
         */
//        Observable.empty()
//                .subscribe(new Observer < Object > () {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//                        Log.d(TAG, "==================onNext");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError " + e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete");
//                    }
//                });


        /**
         * map(), 可以将被观察者发送的数据类型转变成其他的类型
         */
//        Observable.just(1, 2, 3)
//                .map(new Function< Integer, String >() {
//                    @Override
//                    public String apply(Integer integer) throws Exception {
//                        return "I'm " + integer;
//                    }
//                })
//                .subscribe(new Observer < String > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "===================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.e(TAG, "===================onNext " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * flatMap(), 这个方法可以将事件序列中的元素进行整合加工，返回一个**新的被观察者。**
         */
//        Observable.fromIterable(personList)//personList 是一个person 的List
//                .map(new Function < Person, List < Plan >> () {
//                    @Override
//                    public List < Plan > apply(Person person) throws Exception {
//                        return person.getPlanList();
//                    }
//                })
//                .subscribe(new Observer < List < Plan >> () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List < Plan > plans) {
//                        for (Plan plan: plans) {
//                            List < String > planActionList = plan.getActionList();
//                            for (String action: planActionList) {
//                                Log.d(TAG, "==================action " + action);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        Observable.fromIterable(personList)
//                .flatMap(new Function < Person, ObservableSource < Plan >> () {
//                    @Override
//                    public ObservableSource < Plan > apply(Person person) {
//                        return Observable.fromIterable(person.getPlanList());
//                    }
//                })
//                .flatMap(new Function < Plan, ObservableSource < String >> () {
//                    @Override
//                    public ObservableSource < String > apply(Plan plan) throws Exception {
//                        return Observable.fromIterable(plan.getActionList());
//                    }
//                })
//                .subscribe(new Observer < String > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "==================action: " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * concatMap(),concatMap() 和 flatMap() 基本上是一样的，只不过 concatMap() 转发出来的事件是有序的，而 flatMap() 是无序的。
         */
//        Observable.fromIterable(personList)
//                .flatMap(new Function < Person, ObservableSource < Plan >> () {
//                    @Override
//                    public ObservableSource < Plan > apply(Person person) {
//                        if ("chan".equals(person.getName())) {
//                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MILLISECONDS);
//                        }
//                        return Observable.fromIterable(person.getPlanList());
//                    }
//                })
//                .subscribe(new Observer < Plan > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Plan plan) {
//                        Log.d(TAG, "==================plan " + plan.getContent());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         *buffer(), 从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出。
         * count 缓冲区元素的数量，skip 就代表缓冲区满了之后，发送下一次事件序列的时候要跳过多少元素。
         */
//        Observable.just(1, 2, 3, 4, 5)
//                .buffer(2, 1)
//                .subscribe(new Observer < List < Integer >> () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List < Integer > integers) {
//                        Log.d(TAG, "================缓冲区大小： " + integers.size());
//                        for (Integer i: integers) {
//                            Log.d(TAG, "================元素： " + i);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * groupBy(), 将发送的数据进行分组，每个分组都会返回一个被观察者。
         */
//        Observable.just(5, 2, 3, 4, 1, 6, 8, 9, 7, 10)
//                .groupBy(new Function < Integer, Integer > () {
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        return integer % 3;
//                    }
//                })
//                .subscribe(new Observer <GroupedObservable< Integer, Integer >> () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "====================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(final GroupedObservable < Integer, Integer > integerIntegerGroupedObservable) {
//                        Log.d(TAG, "====================onNext ");
//                        integerIntegerGroupedObservable.subscribe(new Observer < Integer > () {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//                                Log.d(TAG, "====================GroupedObservable onSubscribe ");
//                            }
//
//                            @Override
//                            public void onNext(Integer integer) {
//                                Log.d(TAG, "====================GroupedObservable onNext  groupName: " + integerIntegerGroupedObservable.getKey() + " value: " + integer);
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Log.d(TAG, "====================GroupedObservable onError ");
//                            }
//
//                            @Override
//                            public void onComplete() {
//                                Log.d(TAG, "====================GroupedObservable onComplete ");
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "====================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "====================onComplete ");
//                    }
//                });

        /**
         * scan(), 将数据以一定的逻辑聚合起来
         */
//        Observable.just(1, 2, 3, 4, 5)
//                .scan(new BiFunction< Integer, Integer, Integer >() {
//                    @Override//           上次累加的结果？，  新数值？
//                    public Integer apply(Integer integer, Integer integer2) throws Exception {
//                        Log.d(TAG, "====================apply ");
//                        Log.d(TAG, "====================integer " + integer);
//                        Log.d(TAG, "====================integer2 " + integer2);
//                        return integer + integer2;
//                    }
//                })
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "====================accept " + integer);
//                    }
//                });

        /**
         * window()，发送指定数量的事件时，就将这些事件分为一组。window 中的 count 的参数就是代表指定的数量，例如将 count 指定为2，那么每发2个数据就会将这2个数据分成一组。
         */
//        Observable.just(1, 2, 3, 4, 5)
//                .window(2)
//                .subscribe(new Observer < Observable < Integer >> () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "=====================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Observable < Integer > integerObservable) {
//                        integerObservable.subscribe(new Observer < Integer > () {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//                                Log.d(TAG, "=====================integerObservable onSubscribe ");
//                            }
//
//                            @Override
//                            public void onNext(Integer integer) {
//                                Log.d(TAG, "=====================integerObservable onNext " + integer);
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Log.d(TAG, "=====================integerObservable onError ");
//                            }
//
//                            @Override
//                            public void onComplete() {
//                                Log.d(TAG, "=====================integerObservable onComplete ");
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "=====================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "=====================onComplete ");
//                    }
//                });

        /**
         * concat(), 可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。需要注意的是，concat() 最多只可以发送4个事件。
         */
//        Observable.concat(Observable.just(1, 2),
//                Observable.just(3, 4),
//                Observable.just(5, 6),
//                Observable.just(7, 8))
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * concatArray(),与 concat() 作用一样，不过 concatArray() 可以发送多于 4 个被观察者。
         */
//        Observable.concatArray(Observable.just(1, 2),
//                Observable.just(3, 4),
//                Observable.just(5, 6),
//                Observable.just(7, 8),
//                Observable.just(9, 10))
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * merge(), 这个方法月 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行发送事件。
         */
//        Observable.merge(
//                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
//                    @Override
//                    public String apply(Long aLong) throws Exception {
//                        return "A" + aLong;
//                    }
//                }),
//                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
//                    @Override
//                    public String apply(Long aLong) throws Exception {
//                        return "B" + aLong;
//                    }
//                }))
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "=====================onNext " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * concatArrayDelayError() & mergeArrayDelayError()
         *
         * 在 concatArray() 和 mergeArray() 两个方法当中，如果其中有一个被观察者发送了一个 Error 事件，那么就会停止发送事件，
         * 如果你想 onError() 事件延迟到所有被观察者都发送完事件后再执行的话，就可以使用  concatArrayDelayError() 和 mergeArrayDelayError()
         */
//        Observable.concatArrayDelayError(
//                Observable.create(new ObservableOnSubscribe < Integer > () {
//                    @Override
//                    public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                        e.onNext(1);
//                        e.onError(new NumberFormatException());
//                    }
//                }), Observable.just(2, 3, 4))
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "===================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "===================onError " + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        /**
         * zip(),会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合起来，最终发送的事件数量会与源 Observable 中最少事件的数量一样。
         */
//        Observable.zip(Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
//                        .map(new Function<Long, String>() {
//                            @Override
//                            public String apply(Long aLong) throws Exception {
//                                String s1 = "A" + aLong;
//                                Log.d(TAG, "===================A 发送的事件 " + s1);
//                                return s1;
//                            }}),
//                Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS)
//                        .map(new Function<Long, String>() {
//                            @Override
//                            public String apply(Long aLong) throws Exception {
//                                String s2 = "B" + aLong;
//                                Log.d(TAG, "===================B 发送的事件 " + s2);
//                                return s2;
//                            }
//                        }),
//                new BiFunction<String, String, String>() {// 参数一：输入；参数二： 输入； 参数三： 输出格式？//用以组合的函数
//                    @Override
//                    public String apply(String s, String s2) throws Exception {
//                        String res = s + s2;
//                        return res;
//                    }
//                })
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "===================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "===================onNext " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "===================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "===================onComplete ");
//                    }
//                });

        /**
         * combineLatest() & combineLatestDelayError()
         *
         * combineLatest() 的作用与 zip() 类似，但是 combineLatest() 发送事件的序列是与发送的时间线有关的，
         * 当 combineLatest() 中所有的 Observable 都发送了事件，只要其中有一个 Observable 发送事件，这个事件就会和其他 Observable 最近发送的事件结合起来发送，这样可能还是比较抽象，看看以下例子代码。
         */
//        Observable.combineLatest(
//                Observable.intervalRange(1, 4, 1, 1, TimeUnit.SECONDS)
//                        .map(new Function<Long, String>() {
//                            @Override
//                            public String apply(Long aLong) throws Exception {
//                                String s1 = "A" + aLong;
//                                Log.d(TAG, "===================A 发送的事件 " + s1);
//                                return s1;
//                            }
//                        }),
//                Observable.intervalRange(1, 5, 2, 2, TimeUnit.SECONDS)
//                        .map(new Function<Long, String>() {
//                            @Override
//                            public String apply(Long aLong) throws Exception {
//                                String s2 = "B" + aLong;
//                                Log.d(TAG, "===================B 发送的事件 " + s2);
//                                return s2;
//                            }
//                        }),
//                new BiFunction<String, String, String>() {
//                    @Override
//                    public String apply(String s, String s2) throws Exception {
//                        String res = s + s2;
//                        return res;
//                    }
//                })
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "===================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "===================最终接收到的事件 " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "===================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "===================onComplete ");
//                    }
//                });

        /**
         * reduce()， 与 scan() 操作符的作用一样，也是将发送数据以一定逻辑聚合起来，
         * 这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，而 reduce() 会将所有数据聚合在一起才会发送事件给观察者。
         *
         * 前2个数据聚合之后，然后再与后1个数据进行聚合
         */
//        Observable.just(0, 1, 2, 3)
//                .reduce(new BiFunction < Integer, Integer, Integer > () {
//                    @Override
//                    public Integer apply(Integer integer, Integer integer2) throws Exception {
//                        int res = integer + integer2;
//                        Log.d(TAG, "====================integer " + integer);
//                        Log.d(TAG, "====================integer2 " + integer2);
//                        Log.d(TAG, "====================res " + res);
//                        return res;
//                    }
//                })
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "==================accept " + integer);
//                    }
//                });

        /**
         * collect()， 将数据收集到数据结构当中。
         */
//        Observable.just(1, 2, 3, 4)
//                .collect(new Callable < ArrayList < Integer >> () {
//                             @Override
//                             public ArrayList < Integer > call() throws Exception {
//                                 return new ArrayList < > ();
//                             }
//                         },
//                        new BiConsumer< ArrayList < Integer > , Integer >() {
//                            @Override
//                            public void accept(ArrayList < Integer > integers, Integer integer) throws Exception {
//                                integers.add(integer);
//                            }
//                        })
//                .subscribe(new Consumer < ArrayList < Integer >> () {
//                    @Override
//                    public void accept(ArrayList < Integer > integers) throws Exception {
//                        Log.d(TAG, "===============accept " + integers);
//                    }
//                });

        /**
         * startWith() & startWithArray(), 在发送事件之前追加事件，startWith() 追加一个事件，startWithArray() 可以追加多个事件。追加的事件会先发出。
         */
//        Observable.just(5, 6, 7)
//                .startWithArray(2, 3, 4)
//                .startWith(1)
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "================accept " + integer);
//                    }
//                });

        /**
         * count(), 返回被观察者发送事件的数量。
         */
//        Observable.just(1, 2, 3)
//                .count()
//                .subscribe(new Consumer < Long > () {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.d(TAG, "=======================aLong " + aLong);
//                    }
//                });

        /**
         * delay(), 延迟一段事件发送事件。
         */
//        Observable.just(1, 2, 3)
//                .delay(2, TimeUnit.SECONDS)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "=======================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "=======================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "=======================onComplete");
//                    }
//                });

        /**
         * doOnEach(), Observable 每发送一件事件之前都会先回调这个方法。
         *
         * 每发送一个事件之前都会回调 doOnEach 方法，并且可以取出 onNext() 发送的值。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                //      e.onError(new NumberFormatException());
//                e.onComplete();
//            }
//        })
//                .doOnEach(new Consumer<Notification<Integer>>() {
//                    @Override
//                    public void accept(Notification<Integer> integerNotification) throws Exception {
//                        Log.d(TAG, "==================doOnEach " + integerNotification.getValue());
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * doOnNext(), Observable 每发送 onNext() 之前都会先回调这个方法。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .doOnNext(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "==================doOnNext " + integer);
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * doAfterNext(), Observable 每发送 onNext() 之后都会回调这个方法。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .doAfterNext(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "==================doAfterNext " + integer);
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         *doOnComplete(), Observable 每发送 onComplete() 之前都会回调这个方法。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .doOnComplete(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.d(TAG, "==================doOnComplete ");
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * doOnError(),Observable 每发送 onError() 之前都会回调这个方法。
         */

        /**
         * doOnSubscribe(), Observable 每发送 onSubscribe() 之前都会回调这个方法。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .doOnSubscribe(new Consumer < Disposable > () {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        Log.d(TAG, "==================doOnSubscribe ");
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * doOnDispose(), 当调用 Disposable 的 dispose() 之后回调该方法。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .doOnDispose(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.d(TAG, "==================doOnDispose ");
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    private Disposable d;
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                        this.d = d;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                        d.dispose();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * doOnLifecycle(), 在回调 onSubscribe 之前回调该方法的第一个参数的回调方法，可以使用该回调方法决定是否取消订阅
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .doOnLifecycle(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        //disposable.dispose(); //使用 doOnLifecycle 进行取消订阅, doOnDispose Action 和 doOnLifecycle Action 都没有被回调
//                        Log.d(TAG, "==================doOnLifecycle accept");
//                    }
//                }, new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.d(TAG, "==================doOnLifecycle Action");
//                    }
//                })
//                .doOnDispose(
//                        new Action() {
//                            @Override
//                            public void run() throws Exception {
//                                Log.d(TAG, "==================doOnDispose Action");
//                            }
//                        })
//                .subscribe(new Observer<Integer>() {
//                    private Disposable d;
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                        this.d = d;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                        d.dispose();//*****************取消订阅后回调doOnDispose &  doOnLifecycle
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//
//                });

        /**
         * doOnTerminate() & doAfterTerminate(),
         * doOnTerminate 是在 onError 或者 onComplete 发送之前回调，
         * 而 doAfterTerminate 则是 onError 或者 onComplete 发送之后回调。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
////      e.onError(new NullPointerException());
//                e.onComplete();
//            }
//        })
//                .doOnTerminate(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.d(TAG, "==================doOnTerminate ");
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//
//                });

        /**
         * doFinally(), 在所有事件发送完毕之后回调该方法。
         */

        /**
         * onErrorReturn(), 当接受到一个 onError() 事件之后回调，返回的值会回调 onNext() 方法，并正常结束该事件序列。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onError(new NullPointerException());
//            }
//        })
//                .onErrorReturn(new Function<Throwable, Integer>() {
//                    @Override
//                    public Integer apply(Throwable throwable) throws Exception {
//                        Log.d(TAG, "==================onErrorReturn " + throwable);
//                        return 404;
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * onErrorResumeNext(),当接收到 onError() 事件时，返回一个新的 Observable，并正常结束事件序列。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onError(new NullPointerException());
//            }
//        })
//                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
//                    @Override
//                    public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
//                        Log.d(TAG, "==================onErrorResumeNext " + throwable);
//                        return Observable.just(4, 5, 6);
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * onExceptionResumeNext(),与 onErrorResumeNext() 作用基本一致，但是这个方法只能捕捉 Exception。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onError(new Exception("404"));
//            }
//        })
//                .onExceptionResumeNext(new Observable<Integer>() {
//                    @Override
//                    protected void subscribeActual(Observer<? super Integer> observer) {
//                        observer.onNext(333);
//                        observer.onComplete();
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * retry(), 如果出现错误事件，则会重新发送所有事件序列。times 是代表重新发的次数。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onError(new Exception("404"));
//            }
//        })
//                .retry(2)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         *  retryUntil(),出现错误事件之后，可以通过此方法判断是否继续发送事件.
         */
//        final int[] i = {0};
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onError(new Exception("404"));
//            }
//        })
//                .retryUntil(new BooleanSupplier() {
//                    @Override
//                    public boolean getAsBoolean() throws Exception {
//                        Log.d(TAG, "==================retryUntil ");
//                        if (i[0] == 12) {
//                            return true;
//                        }
//                        return false;
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * retryWhen(),
         * 当被观察者接收到异常或者错误事件时会回调该方法，这个方法会返回一个新的被观察者。
         * 如果返回的被观察者发送 Error 事件则之前的被观察者不会继续发送事件，如果发送正常事件则之前的被观察者会继续不断重试发送事件。
         */

//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("chan");
//                e.onNext("ze");
//                e.onNext("de");
//                //e.onError(new Exception("404"));
//                e.onError(new Exception("303"));
//                e.onNext("haha");
//            }
//        })
//                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
//                        return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
//                            @Override
//                            public ObservableSource<?> apply(Throwable throwable) throws Exception {
//                                if (!throwable.toString().equals("java.lang.Exception: 404")) {
//                                    return Observable.just("可以忽略的异常");
//                                } else {
//                                    return Observable.error(new Throwable("终止啦"));
//                                }
//                            }
//                        });
//                    }
//                })
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "==================onNext " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError " + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * repeat(),重复发送被观察者的事件，times 为发送次数。repeat()结束后调用onComplete.
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .repeat(2)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "===================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "===================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "===================onComplete ");
//                    }
//                });

        /**
         * repeatWhen(), 这个方法可以会返回一个新的被观察者设定一定逻辑来决定是否重复发送事件。
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
//                        return Observable.empty();
//                        //return Observable.error(new Exception("404"));
//                        //return Observable.just(4); //null;
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "===================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "===================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "===================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "===================onComplete ");
//                    }
//                });

        /**
         * subscribeOn().指定被观察者的线程，要注意的时，如果多次调用此方法，只有第一次有效
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.d(TAG, "=========================currentThread name: " + Thread.currentThread().getName());
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "======================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "======================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "======================onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "======================onComplete");
//                    }
//                });

        /**
         * observeOn(), 指定观察者的线程，每指定一次就会生效一次。
         */
//        Observable.just(1, 2, 3)
//                .observeOn(Schedulers.newThread())
//                .flatMap(new Function < Integer, ObservableSource < String >> () {
//                    @Override
//                    public ObservableSource < String > apply(Integer integer) throws Exception {
//                        Log.d(TAG, "======================flatMap Thread name " + Thread.currentThread().getName());
//                        Log.d(TAG, "======================chan" + integer);
//                        return Observable.just("chan" + integer);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer < String > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "======================onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "======================onNext Thread name " + Thread.currentThread().getName());
//                        Log.d(TAG, "======================onNext " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "======================onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "======================onComplete");
//                    }
//                });

        /**
         * filter(),通过一定逻辑来过滤被观察者发送的事件，如果返回 true 则会发送事件，否则不会发送。
         */
//        final int[] i = {0};
//        Observable.just(1, 2, 3)
//                .filter(new Predicate< Integer >() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer < 2;
//                    }
//                })
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * ofType(),可以过滤不符合该类型事件
         */
//        final int[] i = {0};
//        Observable.just(1, 2, 3, "chan", "zhide")
//                .ofType(Integer.class)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * skip(), 跳过正序某些事件，count 代表跳过事件的数量
         */
//        final int[] i = {0};
//        Observable.just(1, 2, 3)
//                .skip(2)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * distinct(), 过滤事件序列中的重复事件。
         */
//        final int[] i = {0};
//        Observable.just(1, 2, 3, 3, 2, 1)
//                .distinct()
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * distinctUntilChanged(), 过滤掉连续重复的事件
         */
//        final int[] i = {0};
//        Observable.just(1, 2, 3, 3, 2, 1)
//                .distinctUntilChanged()
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * take(), 控制观察者接收的事件的数量。
         */
//        final int[] i = {0};
//        Observable.just(1, 2, 3, 4, 5)
//                .take(3)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "==================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        i[0] += integer;
//                        Log.d(TAG, "==================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "==================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "==================onComplete ");
//                    }
//                });

        /**
         * debounce(),如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onNext(1);
//                Thread.sleep(900);
//                e.onNext(2);
//            }
//        })
//                .debounce(1, TimeUnit.SECONDS)
//                .subscribe(new Observer < Integer > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "===================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "===================onNext " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "===================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "===================onComplete ");
//                    }
//                });

        /**
         * firstElement() && lastElement()，firstElement() 取事件序列的第一个元素，lastElement() 取事件序列的最后一个元素。
         */
//        Observable.just(1, 2, 3, 4)
//                .firstElement()
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "====================firstElement " + integer);
//                    }
//                });
//
//        Observable.just(1, 2, 3, 4)
//                .lastElement()
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "====================lastElement " + integer);
//                    }
//                });

        /**
         * elementAt() & elementAtOrError()，
         * elementAt() 可以指定取出事件序列中事件，但是输入的 index 超出事件序列的总数的话就不会出现任何结果。这种情况下，你想发出异常信息的话就用 elementAtOrError() 。
         */
//        Observable.just(1, 2, 3, 4)
//                .elementAtOrError(1)
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "====================accept " + integer);
//                    }
//                });

        /**
         * all()， 判断事件序列是否全部满足某个事件，如果都满足则返回 true，反之则返回 false。
         */
//        Observable.just(1, 2, 3, 4)
//                .all(new Predicate < Integer > () {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer < 5;
//                    }
//                })
//                .subscribe(new Consumer < Boolean > () {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        Log.d(TAG, "==================aBoolean " + aBoolean);
//                    }
//                });

        /**
         * takeWhile()， 可以设置条件，当某个数据满足条件时就会发送该数据，反之则不发送。
         */
//        Observable.just(1, 2, 3, 4)
//                .takeWhile(new Predicate < Integer > () {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer < 3;
//                    }
//                })
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "========================integer " + integer);
//                    }
//                });

        /**
         *  skipWhile()， 可以设置条件，当某个数据满足条件时不发送该数据，反之则发送。
         */
//        Observable.just(1, 2, 3, 4)
//                .skipWhile(new Predicate < Integer > () {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer < 3;
//                    }
//                })
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "========================integer " + integer);
//                    }
//                });

        /**
         * takeUntil()， 可以设置条件，当事件满足此条件时，下一次的事件就**不会**被发送了。
         */
//        Observable.just(1, 2, 3, 4, 5, 6)
//                .takeUntil(new Predicate < Integer > () {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer > 3;
//                    }
//                })
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "========================integer " + integer);
//                    }
//                });

        /**
         * skipUntil()，当 skipUntil() 中的 Observable 发送事件了，原来的 Observable 才会发送事件给观察者。
         * 两个observable同时记时
         */
//        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS)
//                .skipUntil(Observable.intervalRange(6, 5, 3, 1, TimeUnit.SECONDS))
//                .subscribe(new Observer < Long > () {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "========================onSubscribe ");
//                    }
//
//                    @Override
//                    public void onNext(Long along) {
//                        Log.d(TAG, "========================onNext " + along);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "========================onError ");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "========================onComplete ");
//                    }
//                });

        /**
         * sequenceEqual()， 判断两个 Observable 发送的事件是否相同。
         */
//        Observable.sequenceEqual(Observable.just(1, 2, 3),
//                Observable.just(1, 2, 3))
//                .subscribe(new Consumer < Boolean > () {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        Log.d(TAG, "========================onNext " + aBoolean);
//                    }
//                });

        /**
         * contains()， 判断事件序列中是否含有某个元素，如果有则返回 true，如果没有则返回 false。
         */
//        Observable.just(1, 2, 3)
//                .contains(3)
//                .subscribe(new Consumer < Boolean > () {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        Log.d(TAG, "========================onNext " + aBoolean);
//                    }
//                });

        /**
         * isEmpty()， 判断事件序列是否为空。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onComplete();
//            }
//        })
//                .isEmpty()
//                .subscribe(new Consumer < Boolean > () {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        Log.d(TAG, "========================onNext " + aBoolean);
//                    }
//                });

        /**
         * amb()
         * amb() 要传入一个 Observable 集合，但是只会发送最先发送事件的 Observable 中的事件，其余 Observable 将会被丢弃。
         */
//        ArrayList < Observable < Long >> list = new ArrayList < > ();
//
//        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
//        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));
//
//        Observable.amb(list)
//                .subscribe(new Consumer < Long > () {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.d(TAG, "========================aLong " + aLong);
//                    }
//                });

        /**
         * defaultIfEmpty()，如果观察者只发送一个 onComplete() 事件，则可以利用这个方法发送一个值。
         */
//        Observable.create(new ObservableOnSubscribe < Integer > () {
//
//            @Override
//            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
//                e.onComplete();
//            }
//        })
//                .defaultIfEmpty(666)
//                .subscribe(new Consumer < Integer > () {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "========================onNext " + integer);
//                    }
//                });






















































































    }

    public class Person {

        private String name;
        private List<Plan> planList = new ArrayList<>();

        public Person(String name, List<Plan> planList) {
            this.name = name;
            this.planList = planList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Plan> getPlanList() {
            return planList;
        }

        public void setPlanList(List<Plan> planList) {
            this.planList = planList;
        }

    }

    public class Plan {

        private String time;
        private String content;
        private List<String> actionList = new ArrayList<>();

        public Plan(String time, String content) {
            this.time = time;
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getActionList() {
            return actionList;
        }

        public void setActionList(List<String> actionList) {
            this.actionList = actionList;
        }
    }


}
