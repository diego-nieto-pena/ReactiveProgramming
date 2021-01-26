package com.reactive.callback;

public class CallBackMain {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				new CallBackMain().runAsynch(new CallBack() {

					@Override
					public void call() {
						System.out.println("Callback called!!");
					}
				});

			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println("Main thread started!");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread finished!");
	}

	public void runAsynch(CallBack callBack) {
		System.out.println("Running Asynchronous task!");
		sleep(1000);
		callBack.call();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
