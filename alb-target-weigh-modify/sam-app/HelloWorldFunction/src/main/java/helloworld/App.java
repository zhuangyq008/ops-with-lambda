package helloworld;

import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancingClientBuilder;
import com.amazonaws.services.elasticloadbalancingv2.model.Action;
import com.amazonaws.services.elasticloadbalancingv2.model.ActionTypeEnum;
import com.amazonaws.services.elasticloadbalancingv2.model.ModifyListenerRequest;
import com.amazonaws.services.elasticloadbalancingv2.model.Rule;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import model.aws.AWSEvent;
import model.aws.ELBStateChangeNotification;


/**
 * Handler for EventBridge invocations of a Lambda function target
 */
public class App implements RequestHandler<AWSEvent<ELBStateChangeNotification>, String> {

    public String handleRequest(AWSEvent<ELBStateChangeNotification> event, Context context) {
        AmazonElasticLoadBalancing elbv2 = AmazonElasticLoadBalancingClientBuilder.defaultClient();
        System.getenv().forEach((k,v)->{
            System.out.println(k+"="+v);

        });
        System.out.println("event: "+event);
        ELBStateChangeNotification detail = event.getDetail();
        // 获取当前目标组的所有目标
        String listenArn = detail.getElbListenArn();
        String masterTGArn = detail.getMasterTargetGroupArn();
        ModifyListenerRequest listenReq = new ModifyListenerRequest().withListenerArn(listenArn);
        Action defAction = new Action().withType(ActionTypeEnum.Forward)
            .withTargetGroupArn(masterTGArn);
        Rule defaultRule = new Rule()
            .withActions(defAction)
            .withIsDefault(true);
            listenReq.withDefaultActions(defAction);
            elbv2.modifyListener(listenReq);
        // 返回处理结果
        return "目标组权重已更新";
    }
    

}
