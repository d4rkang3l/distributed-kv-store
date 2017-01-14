package A2.client;

import com.google.protobuf.InvalidProtocolBufferException;

import A2.proto.RequestPayload.ReqPayload;

public class ProtocolBufferClient {

    public static byte[] serializeRequestPayload(int snum) {
        ReqPayload.Builder reqPayload = ReqPayload.newBuilder();

        System.out.println("Entered student ID: " + snum);
        reqPayload.setStudentID(snum);

        return reqPayload.build().toByteArray();
    }

    public static ReqPayload deserializeRequestPayload(byte[] requestPayloadSerial) {
        ReqPayload reqPayload = null;

        try {
            reqPayload = ReqPayload.parseFrom(requestPayloadSerial);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println("Deserialized student ID: " + reqPayload.getStudentID());

        return reqPayload;
    }
}
