package com.example.team27pac_man;

public class CourseModel {
    // string course_name for storing course_name
    // and imgid for storing image id.
    private Integer layoutId;
    private int imgid;

    public CourseModel(Integer layoutId, int imgid) {
        this.layoutId = layoutId;
        this.imgid = imgid;
    }

    public Integer getLayout_id() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
