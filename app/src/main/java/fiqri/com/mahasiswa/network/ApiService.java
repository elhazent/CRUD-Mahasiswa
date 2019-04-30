package fiqri.com.mahasiswa.network;

import fiqri.com.mahasiswa.model.ResponseMahasiswa;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // sesuaikan dengan function yang ada di web service
    @GET("getMahasiswa")
    Call<ResponseMahasiswa> read();


    @FormUrlEncoded
    @POST("insertMahasiswa")
    Call<ResponseMahasiswa> insert(@Field("nim") String nim,
                                 @Field("name") String nama,
                                 @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @POST("updateMahasiswa")
    Call<ResponseMahasiswa> update(@Field("id") String id,
                                 @Field("nim") String nim,
                                 @Field("name") String nama,
                                 @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @POST("deleteMahasiswa")
    Call<ResponseMahasiswa> delete(@Field("id") String id);
}
