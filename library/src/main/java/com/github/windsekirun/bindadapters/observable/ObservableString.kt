package com.github.windsekirun.bindadapters.observable

import androidx.databinding.ObservableField
import android.os.Parcel
import android.os.Parcelable

import java.io.Serializable

/**
 * An observable class that holds a String
 *
 *
 * Observable field classes may be used instead of creating an Observable object. It can also
 * create a calculated field, depending on other fields:
 * <pre>`public class MyDataObject {
 * public final ObservableString mEmail = new ObservableString();
 * }`</pre>
 * Fields of this type should be declared final because bindings only detect changes in the
 * field's value, not of the field itself.
 *
 *
 * This class is parcelable and serializable but callbacks are ignored when the object is
 * parcelled / serialized. Unless you add custom callbacks, this will not be an issue because
 * data binding framework always re-registers callbacks when the view is bound. A parceled
 * ObservableString will lose its dependencies.
 */
class ObservableString : ObservableField<String>, Parcelable, Serializable {
    private var mValue: String? = null

    val isEmpty: Boolean
        get() = mValue == null || mValue!!.isEmpty()

    constructor()

    constructor(value: String) {
        this.mValue = value
    }

    override fun get(): String {
        return this.mValue ?: ""
    }

    override fun set(value: String) {
        if (!equals(value, this.mValue)) {
            this.mValue = value
            this.notifyChange()
        }

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.mValue)
    }

    companion object {
        internal const val serialVersionUID = 1L

        @JvmField
        val CREATOR: Parcelable.Creator<ObservableString> = object : Parcelable.Creator<ObservableString> {
            override fun createFromParcel(source: Parcel): ObservableString {
                return ObservableString(source.readString())
            }

            override fun newArray(size: Int): Array<ObservableString?> {
                return arrayOfNulls(size)
            }
        }

        fun equals(a: Any?, b: Any?): Boolean {
            return a == b || a != null && a == b
        }
    }
}
