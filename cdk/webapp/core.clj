(ns webapp.core
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [stedi.cdk.alpha :as cdk]))

(cdk/import [[App Construct Duration Stack] :from "@aws-cdk/core"]
            [[Bucket BucketAccessControl] :from "@aws-cdk/aws-s3"]
            [[BucketDeployment Source] :from "@aws-cdk/aws-s3-deployment"]
            [[Code Function Runtime Tracing] :from "@aws-cdk/aws-lambda"]
            [[LambdaRestApi] :from "@aws-cdk/aws-apigateway"])

(def code
  (let [code-path "target/"]
    (Code/fromAsset code-path)))

(def app (App))

(def stack (Stack app "accounting-web-client"))

(def bucket
  (Bucket stack
          "accounting-web-bucket"
          {:publicReadAccess true
           :websiteIndexDocument "index.html"
           }))

(def deployment
  (BucketDeployment stack
                    "accounting-deployment"
                    {:sources [(Source/asset "dist/")]
                     :destinationBucket bucket
                     }))
