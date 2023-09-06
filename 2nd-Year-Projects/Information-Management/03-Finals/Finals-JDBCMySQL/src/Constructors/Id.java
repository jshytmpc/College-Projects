package Constructors;

import java.io.InputStream;
import java.sql.Blob;

public class Id {
    private InputStream portraitPic;
    private String govIdNo;
    private InputStream govIdPic;
    private String govIdType;

    public Id(InputStream portraitPic, String govIdNo, InputStream govIdPic, String govIdType) {
        this.portraitPic = (InputStream) portraitPic;
        this.govIdNo = govIdNo;
        this.govIdPic = govIdPic;
        this.govIdType = govIdType;
    }

    public InputStream getPortraitPic() {
        return portraitPic;
    }

    public void setPortraitPic(Blob portraitPic) {
        this.portraitPic = (InputStream) portraitPic;
    }

    public String getGovIdNo() {
        return govIdNo;
    }

    public void setGovIdNo(String govIdNo) {
        this.govIdNo = govIdNo;
    }

    public InputStream getGovIdPic() {
        return govIdPic;
    }

    public void setGovIdPic(Blob govIdPic) {
        this.govIdPic = (InputStream) govIdPic;
    }

    public String getGovIdType() {
        return govIdType;
    }

    public void setGovIdType(String govIdType) {
        this.govIdType = govIdType;
    }
}
