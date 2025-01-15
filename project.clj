(defproject audiogum/dynamo-embedded-clj "3.0.1-SNAPSHOT"
  :description "Embedded dynamodb for clojure"
  :url "https://github.com/bnwgroupltd/dynamo-embedded-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [integrant "0.13.1"]
                 [com.amazonaws/DynamoDBLocal "2.5.3"]
                 [org.clojure/tools.namespace "1.5.0"]]

  :profiles {:dev {:dependencies [[com.taoensso/faraday "1.12.3"]]}}

  :release-tasks  [["vcs" "assert-committed"]
                   ["change" "version" "leiningen.release/bump-version" "release"]
                   ["vcs" "commit"]
                   ["vcs" "tag" "--no-sign"]
                   ["deploy" "releases"]
                   ["change" "version" "leiningen.release/bump-version" "patch"]
                   ["vcs" "commit"]
                   ["vcs" "push" "origin" "main"]]

  :plugins [[s3-wagon-private "1.3.4"]]

  :repositories {"releases" {:url           "s3p://repo.bowerswilkins.net/releases/"
                             :no-auth       true
                             :sign-releases false}})

