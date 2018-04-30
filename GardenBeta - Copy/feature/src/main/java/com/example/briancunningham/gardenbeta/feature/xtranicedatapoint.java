package com.example.briancunningham.gardenbeta.feature;

import android.os.Parcel;
import android.os.Parcelable;

public class xtranicedatapoint implements Parcelable {
    private int mData;

    /* everything below here is for implementing Parcelable */

    // 99.9% of the time you can just ignore this
    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<xtranicedatapoint> CREATOR = new Parcelable.Creator<xtranicedatapoint>() {
        public xtranicedatapoint createFromParcel(Parcel in) {
            return new xtranicedatapoint(in);
        }

        public xtranicedatapoint[] newArray(int size) {
            return new xtranicedatapoint[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private xtranicedatapoint(Parcel in) {
        mData = in.readInt();
    }
}