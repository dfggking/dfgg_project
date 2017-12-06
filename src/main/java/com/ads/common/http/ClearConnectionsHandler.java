package com.ads.common.http;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 自定义定时清理无效链接(httpclient)
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
public class ClearConnectionsHandler extends Thread {
    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public ClearConnectionsHandler(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
