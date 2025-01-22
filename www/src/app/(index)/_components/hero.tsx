import Image from "next/image";
import NextLink from "next/link";

export function Hero() {
  return (
    <NextLink href="/" className="not-prose flex flex-col items-center py-8">
      <Image
        alt="logo"
        src="/logo.svg"
        width={121}
        height={31}
        className="h-10 w-auto"
      />
    </NextLink>
  );
}
