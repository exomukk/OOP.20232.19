// Small model for getting the numbers for Dan and Quan

package org.oop.oanquan.model;

public class OVuong{
    private int soDan;
    private int soQuan;

    public OVuong(int soDan, int soQuan) {
        this.soDan = soDan;
        this.soQuan = soQuan;
    }

    public int getSoDan() {
        return soDan;
    }

    public void setSoDan(int soDan) {
        this.soDan = soDan;
    }

    public int getSoQuan() {
        return soQuan;
    }

    public void setSoQuan(int soQuan) {
        this.soQuan = soQuan;
    }
}
