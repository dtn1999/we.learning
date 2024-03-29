import React from "react";
import { NextPage } from "next";
import { useRouter } from "next/router";
import { LoadingScreen } from "@we/components";

const SinglePlaygroundPage: NextPage = () => {
  const { query } = useRouter();
  const { codeServerSrc } = query;
  const [isLoading, setIsLoading] = React.useState(true);
  React.useEffect(() => {
    setInterval(async () => {
      setIsLoading(false);
    }, 7000);
  }, [isLoading]);

  return (
    <div className="absolute inset-0 bg-sky-200">
      {isLoading ? (
        <LoadingScreen />
      ) : (
        <iframe
          src={codeServerSrc as string}
          loading="eager"
          className="absolute inset-0 h-full w-full"
        />
      )}
    </div>
  );
};

export default SinglePlaygroundPage;
