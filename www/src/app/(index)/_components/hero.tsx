import Image from "next/image";
import NextLink from "next/link";

import { HeroButton } from "./hero-button";

export function Hero() {
  return (
    <div className="not-prose relative flex min-h-screen flex-col items-center pt-16">
      <div className="absolute inset-0 -z-10">
        <Image
          alt=""
          src="/screenshot-1.png"
          fill
          className="object-cover blur-sm"
        />
      </div>
      <NextLink href="/" className="">
        <Image
          alt="logo"
          src="/logo.png"
          width={200}
          height={40}
          className="h-24 w-auto"
        />
      </NextLink>
      <div className="mt-12 max-w-lg px-4 text-sm">
        ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文ここに紹介文
      </div>
      <div className="mt-16 flex gap-4">
        <HeroButton className="bg-primary-500 text-white" href="#">
          ダウンロード
        </HeroButton>
        <HeroButton className="border border-primary-500" href="#">
          あそびかた
        </HeroButton>
      </div>
    </div>
  );
}
