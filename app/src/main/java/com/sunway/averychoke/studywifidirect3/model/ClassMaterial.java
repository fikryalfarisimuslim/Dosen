package com.sunway.averychoke.studywifidirect3.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by AveryChoke on 29/1/2017.
 */

public class ClassMaterial implements Serializable, Comparable<ClassMaterial> {
    public enum Status {
        NORMAL, DOWNLOADING, PENDING, ERROR;
    }

    public static long mCounter = 0;

    private long mId;
    private String mName;
    private boolean mVisible;
    private Status mStatus;

    public ClassMaterial(String name, boolean visible) {
        this(++mCounter, name, visible, Status.NORMAL);
    }

    public ClassMaterial(long id, String name, boolean visible) {
        this(id, name, visible, Status.NORMAL);
    }

    public ClassMaterial(long id, String name, boolean visible, Status status) {
        mId = id;
        mName = name;
        mVisible = visible;
        mStatus = status;
    }

    public void updateId() {
        mId = ++mCounter;
    }

    public boolean hasCheck() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassMaterial)) {
            return false;
        }
        ClassMaterial classMaterial = (ClassMaterial) o;
        return classMaterial.mId == mId;
    }

    @Override
    public int compareTo(@NonNull ClassMaterial classMaterial) {
        if (mStatus == Status.PENDING && classMaterial.mStatus != Status.PENDING) {
            return 1;
        } else if (mStatus != Status.PENDING && classMaterial.mStatus == Status.PENDING) {
            return -1;
        } else {
            return mName.toLowerCase().compareTo(classMaterial.mName.toLowerCase());
        }
    }

    // region get set
    public long getId() {
        return mId;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public boolean isVisible() {
        return mVisible;
    }

    public void setVisible(boolean visible) {
        mVisible = visible;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }
    // endregion get set
}
