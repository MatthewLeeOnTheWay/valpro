package com.security.valpro.entity;

public class EntityCache {
    /*
    * 保存的数据
    * */
    private Object datas;
    /*
    * 设置的数据失效的时间，0表示永不失效
    * */
    private long timeout;
    /*
    * 最后刷新时间
    * */
    private long lastRefreshTime;

    public EntityCache(Object datas, long timeout, long lastRefreshTime) {
        this.datas = datas;
        this.timeout = timeout;
        this.lastRefreshTime = lastRefreshTime;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }
}
