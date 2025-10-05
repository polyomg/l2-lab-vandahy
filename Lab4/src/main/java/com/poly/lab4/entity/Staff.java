package com.poly.lab4.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    private String id;
    @NotBlank(message = "Chưa nhập họ và tên")
    private String name;
    @Builder.Default
    private String photo = "photo.png";
    @NotNull(message = "Chưa chọn giới tính")
    @Builder.Default
    private Boolean gender = true;
    @Builder.Default
    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh không hợp lệ, phải là ngày trong quá khứ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();
    @Builder.Default
    @Min(value = 1000, message = "Lương tối thiếu phải là 1000")
    @NotNull(message = "Chưa nhập lương")
    private Double salary = 108312.7;
    @Builder.Default
    private Integer level = 0;
}
