package id.kotlin.sample.room.data

import android.os.Parcel
import android.os.Parcelable

data class RepoModel(val id: Long,
                     val name: String,
                     val url: String) : Parcelable {


    companion object {
        @JvmField val CREATOR: Parcelable.Creator<RepoModel> = object : Parcelable.Creator<RepoModel> {
            override fun createFromParcel(source: Parcel): RepoModel = RepoModel(source)
            override fun newArray(size: Int): Array<RepoModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readLong(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(name)
        dest.writeString(url)
    }
}